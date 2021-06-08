package com.example.SpringAOP;

import com.example.SpringAOP.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringAopApplication {



	public static void main(String[] args) throws Exception {

		ApplicationContext applicationContext=SpringApplication.run(SpringAopApplication.class, args);
//		Userservice userservice=applicationContext.getBean(Userservice.class);
//		userservice.throwuserException();


	}



}
