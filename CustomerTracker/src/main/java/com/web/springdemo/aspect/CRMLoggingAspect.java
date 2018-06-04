package com.web.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.web.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}

	@Pointcut("execution(* com.web.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.web.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}

	@Pointcut("forControllerPackage() ||forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		myLogger.info("===> @Before Method Name: " + theJoinPoint.getSignature().toString());
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object temp: args) {
			
			myLogger.info("===> Argument: "+ temp);
		}
	}
	
	@AfterReturning(pointcut = "forAppFlow()",
					returning = "result")
	public void afterReturning(JoinPoint theJoinPoint, Object result) {
		myLogger.info("===> After Returning Method Name: " + theJoinPoint.getSignature().toString());
		myLogger.info("==> result: "+result);
	}
	
}
