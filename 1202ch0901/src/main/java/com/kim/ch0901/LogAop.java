package com.kim.ch0901;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop { //공통기능(횡단기능,crosscutting concerns) 클래스(어드바이스)

	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		//ProceedingJoinPoint는 핵심기능 처리하는 인터페이스
		String signatureStr = joinpoint.getSignature().toShortString();
		//getSignature()는 (핵심기능의).실행메서드를 리턴(Signature)
		System.out.println( signatureStr + " is start.");
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			//proceed()는 핵심기능 메서드를 실행하고 다음 advice를 실행
			return obj;	//정상처리후 return함(finally를 실행하고 종료)
		} finally {
			long et = System.currentTimeMillis();
			System.out.println( signatureStr + " is finished.");
			System.out.println( signatureStr  + (et - st));
		}
		
	}
	
}
