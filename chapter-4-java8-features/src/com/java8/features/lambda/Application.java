package com.java8.features.lambda;

public class Application {

	public static void main(String[] args) {
		
		// lambdaAndAnonymousClassSample();
		methodReferenceSample();
	}
	
	private static void methodReferenceSample() {
		
		Operation addition = Operations::add;
		Operation subtraction = Operations::subtract;
		Operation multiplication = Operations::multiply;
		Operation division = Operations::divide;
		
		
		System.out.println(OperationProcessor.process(5, 7, addition));
		System.out.println(OperationProcessor.process(5, 7, subtraction));
		System.out.println(OperationProcessor.process(5, 7, multiplication));
		System.out.println(OperationProcessor.process(5, 7, division));
	}

	private static void lambdaAndAnonymousClassSample() {

		// Lambda scope dışındaki değişkenler final olmalıdır.
		final int SUM_ID = 1;

		/*
		 * Anonim sınıf hali Operation sum = new Operation() {
		 * 
		 * @Override public int operate(int x, int y) {
		 * 
		 * System.out.println("x: " + x); System.out.println("y: " + y);
		 * 
		 * return x + y; } };
		 */

		Operation sum = (x, y) -> {

			System.out.println("x: " + x);
			System.out.println("y: " + y);
			System.out.println(SUM_ID + ". operation was executed!");

			return x + y;
		};

		System.out.println(OperationProcessor.process(5, 7, sum));

		/*
		 * Anonim sınıf hali Operation multiplication = new Operation() {
		 * 
		 * @Override public int operate(int x, int y) {
		 * 
		 * return x * y; } };
		 */

		Operation multiplication = (x, y) -> {

			System.out.println("x: " + x);
			System.out.println("y: " + y);

			return x * y;
		};

		System.out.println(OperationProcessor.process(5, 7, multiplication));

		/*
		 * Anonim sınıf hali Operation division = new Operation() {
		 * 
		 * @Override public int operate(int x, int y) {
		 * 
		 * return x / y; } };
		 */

		Operation division = (x, y) -> {

			System.out.println("x: " + x);
			System.out.println("y: " + y);

			return x * y;
		};

		System.out.println(OperationProcessor.process(5, 7, division));

		Operation mod = (x, y) -> x % y;

		System.out.println(OperationProcessor.process(15, 7, mod));
	}

}
