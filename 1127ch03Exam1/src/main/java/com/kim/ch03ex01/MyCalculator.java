package com.kim.ch03ex01;

public class MyCalculator {
	//Property(����)�� ����
	Calculator calculator;
	private int firstNum;
	private int secondNum;
	
	//������
	public MyCalculator() {
		
	}
	
	//�޼���
	public void add() {
		calculator.addition(firstNum, secondNum);
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	public int getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public int getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
}
