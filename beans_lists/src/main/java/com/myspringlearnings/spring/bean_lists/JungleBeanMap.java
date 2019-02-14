package com.myspringlearnings.spring.bean_lists;

import java.util.HashMap;
import java.util.Map;

///////////////////////////////////////////////////////////////////////////
// 
// this is a class to demonstrate bean as a ref to hashmap 
// 
// map and props can be used interchangeably in most cases. 
// <props> support only String values
// So to use object references, use <map>
//
//////////////////////////////////////////////////////////////////////////

public class JungleBeanMap {

	// hashmap is created by reference of beans
	private Map<String, Animal> animals = new HashMap<String, Animal>();

	public void setAnimals(Map<String, Animal> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Map contains the following\n");

		for (String animal : animals.keySet()) {
			sb.append(animal + " : " + animals.get(animal));
			sb.append("\n");
		}
		return sb.toString();
	}

}
