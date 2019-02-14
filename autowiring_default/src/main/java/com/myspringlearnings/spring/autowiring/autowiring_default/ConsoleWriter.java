package com.myspringlearnings.spring.autowiring.autowiring_default;

public class ConsoleWriter implements LogWriter {

	public void write(String text) {
		System.out.println(text);

	}

}
