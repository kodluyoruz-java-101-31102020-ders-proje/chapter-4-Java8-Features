package com.java8.features.lambda;

import java.util.Date;

public interface Operation {

	int operate(int x, int y);
	
	default Date now()
	{
		return new Date();
	}
}
