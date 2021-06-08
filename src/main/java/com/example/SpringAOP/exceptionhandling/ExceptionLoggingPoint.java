package com.example.SpringAOP.exceptionhandling;



import com.example.SpringAOP.entities.ExceptionLog;
import com.example.SpringAOP.repository.ExceptionLogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;


@Aspect
@Configuration
public class ExceptionLoggingPoint {
    @Autowired
    ExceptionLogRepository exceptionLogRepository;

    @AfterThrowing(pointcut = "execution(* com.example.SpringAOP.service.*.*(..))", throwing = "ex")
    public void logError(JoinPoint jp, Exception ex)throws Throwable {
        System.out.println("Exception>>>>>>>>>>");
        System.out.println(jp.getSignature());
        System.out.println(jp.getSourceLocation());

        ExceptionLog exceptionLog=new ExceptionLog(ex.getMessage(),new Date());
       exceptionLogRepository.save(exceptionLog);
//

    }
}