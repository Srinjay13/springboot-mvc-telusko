package com.telusko.SpringMVCBoot;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	//Aspect will be a class where we will have all the methods for doing our tasks in a separate class altogether from the Business Logic class
	//Join Point will be the point of execution where we want to call where we want to call a particular advice
	//Advice is the actual method we want to call, for example Log in our case for now
	//PointCut is the expression that we will use to define the method
	//Weaving specifies when we want to connect it
	//In general, we have 3 kinds of advice :"Before", "After", "Around"(which is during the execution of the method)
	
	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.telusko.SpringMVCBoot.CoderController.getCoders())")
	public void logBefore() {
//		System.out.println("getCoders method called"); -> Instead of using sysout to print the log, we can use Logger to store all the logs
		log.info("getCoders method called");
//		To mention what level of logging is required, we can define that in the application.properties file to maintain that
	}

	@After("execution(public * com.telusko.SpringMVCBoot.CoderController.getCoders())")
	public void logAfter() {
		log.info("getCoders method called");
	}
	
	@AfterReturning("execution(public * com.telusko.SpringMVCBoot.CoderController.getCoders())")
	public void logAfterReturning() {
		log.info("getCoders method called from AfterReturning");
	}
	
	@AfterThrowing("execution(public * com.telusko.SpringMVCBoot.CoderController.getCoders())")
	public void logAfterThrowing() {
		log.info("getCoders method called from AfterThrowing");
	}

}
