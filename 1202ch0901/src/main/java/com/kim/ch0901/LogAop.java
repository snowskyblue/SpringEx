package com.kim.ch0901;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop { //������(Ⱦ�ܱ��,crosscutting concerns) Ŭ����(�����̽�)

	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		//ProceedingJoinPoint�� �ٽɱ�� ó���ϴ� �������̽�
		String signatureStr = joinpoint.getSignature().toShortString();
		//getSignature()�� (�ٽɱ����).����޼��带 ����(Signature)
		System.out.println( signatureStr + " is start.");
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			//proceed()�� �ٽɱ�� �޼��带 �����ϰ� ���� advice�� ����
			return obj;	//����ó���� return��(finally�� �����ϰ� ����)
		} finally {
			long et = System.currentTimeMillis();
			System.out.println( signatureStr + " is finished.");
			System.out.println( signatureStr  + (et - st));
		}
		
	}
	
}
