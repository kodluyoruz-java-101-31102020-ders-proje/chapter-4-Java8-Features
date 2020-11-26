package com.java8.features.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

	public static void main(String[] args) {

		streamApi();
	}

	private static void streamApi() {

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(44);
		numbers.add(54);
		numbers.add(54);
		numbers.add(123);
		numbers.add(1);
		numbers.add(90);
		numbers.add(77);
		numbers.add(77);
		numbers.add(77);
		numbers.add(62);
		numbers.add(91);
		numbers.add(22);
		numbers.add(78);
		numbers.add(78);
		numbers.add(77);
		numbers.add(5);
		numbers.add(14);

		// JDK 7 ve öncesi
		/*
		 * List<Integer> lowerThan10 = new ArrayList<Integer>(); for(Integer number :
		 * numbers) { if(number < 10) { lowerThan10.add(number); } }
		 */

		// forEach sample
		Stream<Integer> stream = numbers.stream();
		Consumer<Integer> printer = (number) -> {
			System.out.println(number);
		};
		stream.forEach(printer);

		// one line
		numbers.stream().forEach((number) -> {
			System.out.println(number);
		});

		// filter sample
		System.out.println("İkiye bölünen sayılar");

		Predicate<Integer> divisionByTwo = (number) -> {
			return (number % 2) == 0;
		};

		numbers.stream().filter(divisionByTwo).forEach(printer);

		// burada yeni bir liste elde ediyoruz. ikiye bölünen sayıları ayrı bir liste
		// olarak aldım.
		List<Integer> divisionByTwoList = numbers.stream().filter(divisionByTwo).collect(Collectors.toList());

		divisionByTwoList.stream().forEach(printer);

		
		Set<Patient> patientSet = new TreeSet<Patient>();
		patientSet.add(new Patient("Batuhan", "Duzgun", "Karın ağrısı", 2));
		patientSet.add(new Patient("Hatice", "Yurt", "Kemik kırığı", 30));
		patientSet.add(new Patient("Ali", "Yurt", "Baş kırığı", 30));
		patientSet.add(new Patient("Ayşe", "Fatma", "Baş ağrısı", 1));
		patientSet.add(new Patient("Ayşe", "Fatma", "Baş ağrısı", 1));
		patientSet.add(new Patient("Ayşe", "Fatma", "Baş ağrısı", 1));
		patientSet.add(new Patient("Ayşe", "Fatma", "Baş ağrısı", 1));

		Predicate<Patient> patientLambda = (patient) -> { 
			
			if(patient.getMaintanenceDay() > 20) {
				return true;
			}
			
			return false;
		};
		
		Set<Patient> patientSubSet = patientSet.stream()
				.filter( patientLambda )
				.collect(Collectors.toSet());

		Consumer<Patient> patientPrinter = (patient) -> System.out.println(patient);
		
		System.out.println("20 günden fazladır hastanede yatan hasta listesi");
		patientSubSet.stream().forEach(patientPrinter);
		
		
		
		// distinct sample
		List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
		
		System.out.println("Mükerrer olmayan sayı listesi");
		distinctNumbers.stream().forEach(printer);
		
		List<Patient> patientList = new ArrayList<Patient>();
		patientList.add(new Patient("Batuhan", "Suzgun", "Karın ağrısı", 2));
		patientList.add(new Patient("Batuhan", "Kuzgun", "Karın ağrısı", 2));
		patientList.add(new Patient("Batuhan", "Duzgun", "Karın ağrısı", 2));
		patientList.add(new Patient("Hatice", "Yurt", "Kemik kırığı", 30));
		patientList.add(new Patient("Ali", "Yurt", "Baş kırığı", 30));
		patientList.add(new Patient("Ayşe", "Azat", "Baş ağrısı", 1));
		patientList.add(new Patient("Aslı", "Ziynet", "Baş ağrısı", 1));
		patientList.add(new Patient("Aylin", "Kalem", "Baş ağrısı", 1));
		patientList.add(new Patient("Alev", "Fındık", "Baş ağrısı", 1));
		
		List<Patient> distinctPatientList = patientList.stream().distinct().collect(Collectors.toList());
		
		System.out.println("Mükerrer olmayan hasta listesi");
		distinctPatientList.stream().forEach(patientPrinter);
		
		
		// sorted sample
		
		// ASC Order
		System.out.println("ASC Order in numbers Collection");
		numbers.stream().sorted().forEach(printer);
		
		// DESC Order
		System.out.println("DESC Order in numbers Collection");
		numbers.stream().sorted(Comparator.reverseOrder()).forEach(printer);
		
		Comparator<Patient> comparator = 
				Comparator.comparing(Patient::getName)
					.thenComparing(Patient::getLastName)
					.thenComparing(Patient::getMaintanenceDay);
		
		List<Patient> sortedPatientList = distinctPatientList.stream()
			.sorted(comparator)
			.collect(Collectors.toList());
		
		System.out.println("Sorted patient list");
		sortedPatientList.stream().forEach(patientPrinter);
		
		
		// anyMatch sample
		boolean result = sortedPatientList.stream()
							.anyMatch( patient -> patient.getMaintanenceDay() > 20 );
		System.out.println(result);
		
		
		// map sample
		// makes data conversion on original collection resource!
		List<String> patientFullNames = sortedPatientList.stream().map( (patient) -> { 
			
			StringBuilder builder = new StringBuilder();
			builder.append(patient.getName());
			builder.append(" ");
			builder.append(patient.getLastName());
			
			return builder.toString();
		} )
		.collect(Collectors.toList());
		
		
		Function<Patient, FullName> fullNameConverter = (patient) -> {
			
			StringBuilder builder = new StringBuilder();
			builder.append(patient.getName());
			builder.append(" ");
			builder.append(patient.getLastName());
			
			return new FullName(builder.toString());
		};
		
		patientFullNames.forEach( (fullName) -> System.out.println(fullName) );
		
		
	 	Set<FullName> fullNameSet = 
	 			sortedPatientList.stream().map( fullNameConverter ).collect(Collectors.toSet());
		
		
	 	fullNameSet.stream().forEach( (f) -> System.out.println(f.getFullName()) );
		
	}
	
}
