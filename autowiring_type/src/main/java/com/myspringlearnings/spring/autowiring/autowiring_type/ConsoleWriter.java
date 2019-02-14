package com.myspringlearnings.spring.autowiring.autowiring_type;

public class ConsoleWriter implements LogWriter {

	public void write(String text) {
		System.out.println(text);

	}

}
