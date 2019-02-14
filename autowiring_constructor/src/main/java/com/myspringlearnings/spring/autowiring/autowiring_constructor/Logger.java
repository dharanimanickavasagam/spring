package com.myspringlearnings.spring.autowiring.autowiring_constructor;

public class Logger {
	private LogWriter consoleWriter;
	private LogWriter fileWriter;

	// the types of consoleWriter and fileWriter are different
	// so autowire them by using
	// 1. byName(by using name/id similar to the property-handles with setters
	// 2. byType (handles with setters)
	// 3. constructor (needs constructor to handle dependency-setters not needed

	public Logger(ConsoleWriter consoleWriter, FileWriter fileWriter) {
		this.consoleWriter = consoleWriter;
		this.fileWriter = fileWriter;
	}

	@Override
	public String toString() {
		return "Logger [consoleWriter=" + consoleWriter + ", fileWriter="
				+ fileWriter + "]";
	}

	// member functions
	public void writeFile(String text) {

		fileWriter.write(text);
	}

	public void writeConsole(String text) {

		consoleWriter.write(text);
	}
}
