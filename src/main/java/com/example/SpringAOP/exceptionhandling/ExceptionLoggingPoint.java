package com.example.SpringAOP.exceptionhandling;



import com.example.SpringAOP.entities.ExceptionLog;
import com.example.SpringAOP.repository.ExceptionLogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Aspect
@Configuration
public class ExceptionLoggingPoint {
    @Autowired
    ExceptionLogRepository exceptionLogRepository;

    @AfterThrowing(pointcut = "execution(* com.example.SpringAOP.*.*.*(..))", throwing = "ex")
    public void logError(JoinPoint jp, Exception ex)throws Throwable {
        System.out.println("Exception>>>>>>>>>>");
        System.out.println(jp.getSignature());
        System.out.println(jp.getSourceLocation());

       // System.out.println(request.getContextPath());
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        System.out.println(request.getRequestURI());
        ExceptionLog exceptionLog=new ExceptionLog(ex.getMessage(),new Date(),request.getRequestURI());
       exceptionLogRepository.save(exceptionLog);
//

    }
}