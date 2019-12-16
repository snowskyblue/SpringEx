package com.kim.ch1001;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop { //AOP�� ��� ó�����ִ� ���Ͻ� Ŭ����
	
	@Pointcut("within(com.kim.ch1001.*)") //pointcut��ġ ����(aop�� ���� ��ġ)
	private void pointcutMethod() {
	}
	
	
	@Around("pointcutMethod()") //advice���� ��� �� arround ��� �ٽɽ��� ���� ���� ���� ��
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
