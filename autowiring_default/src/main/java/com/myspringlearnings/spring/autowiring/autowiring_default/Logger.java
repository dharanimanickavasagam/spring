package com.myspringlearnings.spring.autowiring.autowiring_default;

public class Logger {
	private ConsoleWriter consoleWriter;
	private FileWriter fileWriter;

	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}

	public void setFileWriter(FileWriter fileWriter) {
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
