package com.sopra.scientific.calculator.services;

import org.springframework.stereotype.Service;


@Service
public class ExtractExpressionService {
	private String[] expression;

	public String[] extract(String input) {
		expression = input.split("(?<=[-+*/()^])|(?=[-+*/()^])");
		return expression;
	}
}
