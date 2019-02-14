package com.myspringlearnings.spring.listing;

import java.util.List;

public class FruitBasket {
	private String name;
	private List<String> fruits;

	public FruitBasket(String name, List<String> fruits) {
		super();
		this.name = name;
		this.fruits = fruits;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(name);
		sb.append(" contains \n");

		for (String fruit : fruits) {
			sb.append(fruit);
			sb.append("\n");
		}
		return sb.toString();
	}

}
