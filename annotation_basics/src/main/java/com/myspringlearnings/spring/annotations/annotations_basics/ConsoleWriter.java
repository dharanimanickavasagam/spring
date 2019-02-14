package com.myspringlearnings.spring.annotations.annotations_basics;

public class ConsoleWriter implements LogWriter {

	public void write(String text) {
		System.out.println(text);

	}

}
