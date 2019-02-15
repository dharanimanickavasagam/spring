package com.myspringlearnings.spring.annotations.annotations_qualifiers;

import org.springframework.beans.factory.annotation.Qualifier;

//@Qualifier("fw1")
public class FileWriter implements LogWriter {

	public void write(String text) {
		System.out.println(text);

	}

}
