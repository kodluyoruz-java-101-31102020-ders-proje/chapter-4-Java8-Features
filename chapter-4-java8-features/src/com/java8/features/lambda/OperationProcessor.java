package com.java8.features.lambda;

public class OperationProcessor {

	public static int process(int x, int y, Operation operation) {
		
		System.out.println(operation.now());
		return operation.operate(x, y);
	}
	
}
