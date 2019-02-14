package com.myspringlearnings.spring.annotations.annotations_basics;

import org.springframework.beans.factory.annotation.Autowired;

public class Logger {

	// ///////////////////////////////////////////////////////////////////////////
	//
	// use @Autowired annotation either in one of the following scenarios,
	// 1. at the properties that needs to be wired
	// 2. at the setter methods where the property has to be wired
	// 3. at the constructor that injects the dependency
	//
	// Some interesting thing ?
	// Try removing the @Autowired setter and @Autowired constructor
	// now the private class instance variables have @Autowired annotations
	//
	// Run the code, viola !
	// @Autowired can change the value of the private class instance variables
	// without a getter and constructor
	//
	// ///////////////////////////////////////////////////////////////////////////

	// @Autowired
	private ConsoleWriter consoleWriter;

	// @Autowired
	private FileWriter fileWriter;

	// //////////////////////////////////////////////////////////////////////////////
	//
	// @Autowired
	//
	// public Logger(ConsoleWriter consoleWriter, FileWriter fileWriter) {
	// super();
	// this.consoleWriter = consoleWriter;
	// this.fileWriter = fileWriter;
	// }
	//
	// //////////////////////////////////////////////////////////////////////////////
	//
	// Optional Beans
	// set @Autowired(required = false), spring does not always want
	// consolewriter to bean to be present
	//
	// if it is not present, the control will not be passed to the setter that
	// sets the dependency
	//
	// if it is present, ecpect the normal injection to happen !
	//
	// ////////////////////////////////////////////////////////////////////////////////

	@Autowired(required = false)
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		System.out.println("I am here ");
		this.consoleWriter = consoleWriter;
	}

	@Autowired
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	@Override
	public String toString() {
		return "Logger [consoleWriter=" + consoleWriter + ", fileWriter="
				+ fileWriter + "]";
	}

	public void writeFile(String text) {
		fileWriter.write(text);
	}

	public void writeConsole(String text) {
		if (consoleWriter != null)
			consoleWriter.write(text);
	}
}
