package com.java8.features.lambda;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Application {

	public static void main(String[] args) {

		// lambdaAndAnonymousClassSample();
		// methodReferenceSample();
		preDefinedFunctionalInterfaces();
	}

	private static void preDefinedFunctionalInterfaces() {

		// Function sample
		Function<Integer, String> converter = (x) -> {

			String numberAstext = String.valueOf(x);
			StringBuilder builder = new StringBuilder();
			builder.append("Converted result: ");
			builder.append(numberAstext);
			return builder.toString();
		};

		System.out.println(converter.apply(100));

		
		// Consumer sample
		Consumer<String> builder = TextBuilder::append;

		builder.accept("Ali");
		builder.accept(" ata");
		builder.accept(" bak.");

		System.out.println(TextBuilder.build());

		builder.accept("Işık");
		builder.accept(" ılık");
		builder.accept(" süt");
		builder.accept(" iç.");

		System.out.println(TextBuilder.build());

		
		
		// Supplier sample
		final int max = 1000;
		final Random random = new Random();
		
		Supplier<Integer> randomNumberGenerator = () -> {
			return random.nextInt(max);
		};
		
		System.out.println(randomNumberGenerator.get());
		System.out.println(randomNumberGenerator.get());
		System.out.println(randomNumberGenerator.get());
		
		
		// Predicate sample
		Predicate<Integer> divisibleBy5 = (number) -> number % 5 == 0;
		
		System.out.println(divisibleBy5.test(10));
		System.out.println(divisibleBy5.test(12));
	}

	private static void methodReferenceSample() {

		Operation addition = Operations::add;
		Operation subtraction = Operations::subtract;
		Operation multiplication = Operations::multiply;
		Operation division = Operations::divide;

		int t = subtraction.operate(10, 20);
		System.out.println(t);

		System.out.println(OperationProcessor.process(5, 7, addition));
		System.out.println(OperationProcessor.process(5, 7, subtraction));
		System.out.println(OperationProcessor.process(5, 7, multiplication));
		System.out.println(OperationProcessor.process(5, 7, division));
	}

	private static void lambdaAndAnonymousClassSample() {

		// Lambda scope dışındaki değişkenler final olmalıdır.
		final int SUM_ID = 1;

		/*
		 * Anonim sınıf hali
		 * 
		 * Operation sum = new Operation() {
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
