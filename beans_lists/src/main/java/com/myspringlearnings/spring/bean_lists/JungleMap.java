package com.myspringlearnings.spring.bean_lists;

import java.util.HashMap;
import java.util.Map;

/////////////////////////////////////////////////////////////////////
//
// this is a class to demonstrate hashmap as property to a class 
// and how to inject it to a bean 
//
// to do so, create a bean for JungleMap as junglemap 
// insert <props> element to say that there is a map property
// add a <prop> element for each key value pair 
// add the value in the source code of beans.xml 
//
/////////////////////////////////////////////////////////////////////

public class JungleMap {

	// normal hashmap
	private Map<String, String> foods = new HashMap<String, String>();

	public void setFoods(Map<String, String> foods) {
		this.foods = foods;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Map contains the following\n");

		for (String food : foods.keySet()) {
			sb.append(food + " : " + foods.get(food));
			sb.append("\n");
		}
		return sb.toString();
	}
}
