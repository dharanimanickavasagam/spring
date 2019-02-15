package com.myspringlearnings.spring.annotations.annotations_qualifiers;

import javax.inject.Inject;
import javax.inject.Named;

public class InjectWriter {

	public void writeJSR(String text) {
		System.out.println("I am here");
		System.out.println(text);
	}

}
