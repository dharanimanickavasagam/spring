package com.myspringlearnings.spring.autowiring.autowiring_name;

public class Logger {
	private LogWriter consoleWriter;
	private LogWriter fileWriter;

	public void setConsoleWriter(LogWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}

	public void setFileWriter(LogWriter fileWriter) {
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
