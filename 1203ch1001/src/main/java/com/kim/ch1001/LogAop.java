package com.kim.ch1001;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop { //AOP를 대신 처리해주는 프록시 클래스
	
	@Pointcut("within(com.kim.ch1001.*)") //pointcut위치 지정(aop가 들어가는 위치)
	private void pointcutMethod() {
	}
	
	
	@Around("pointcutMethod()") //advice실행 방식 중 arround 방식 핵심시작 시작 전과 종료 후
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println( signatureStr + " is start.");
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println( signatureStr + " is finished.");
			System.out.println( signatureStr + (et - st));
		}
		
	}
	
	@Before("within(com.kim.ch1001.*)")
	public void beforAdvice() {
		System.out.println("beforAdvice()");
	}
	
}
