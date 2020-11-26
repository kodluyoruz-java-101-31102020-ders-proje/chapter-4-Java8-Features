package com.java8.features.lambda;

public class TextBuilder {

	private static StringBuilder builder;
	
	public static void append(String text) {
		
		if(builder == null) {
			builder = new StringBuilder();
		}
		
		builder.append(text);
	}
	
	public static String build() {
		
		String result = builder.toString();
		
		// builder içeriğini temizliyoruz!
		builder.setLength(0);
		builder.trimToSize();
		
		return result;
	}
	
}
