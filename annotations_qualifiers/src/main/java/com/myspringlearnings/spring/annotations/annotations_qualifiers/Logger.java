package com.myspringlearnings.spring.annotations.annotations_qualifiers;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Logger implements InitializingBean, DisposableBean {

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

	@Autowired
	@Qualifier("cw1")
	private ConsoleWriter consoleWriter;

	private LogWriter fileWriter;

	@Autowired
	@Resource(name = "resourcewriter")
	private ResourceWriter resourceWriter;

	// Add a dependency in pom.xml as javax-inject
	@Inject
	@Named(value = "injectwriter")
	private InjectWriter injectWriter;

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
	// @Qualifier
	// When there are multiple beans to to the same class, and if they have to
	// be injected, to identify them use @Qualifier
	//
	// Define a new qualifier for the bean in the beans.xml, with a name
	// To use the particular bean of particular class, identify them with the
	// name in the @Qualifier
	//
	// To resolve this ambiguity
	// use the same name as the property for the bean id
	// it auto-wires byName
	// if the names are different there is an Error !
	//
	// ////////////////////////////////////////////////////////////////////////////////

	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}

	@Autowired
	@Qualifier("fw1")
	public void setFileWriter(LogWriter fileWriter) {
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

	// ///////////////////////////////////////////////////////////////
	//
	// @Resource is another alternative for @Qualifier
	// JSR 250 standard
	//
	// /////////////////////////////////////////////////////////////////

	public void javaSpecificationRequest250(String text) {
		resourceWriter.writeJSR(text);
	}

	// ///////////////////////////////////////////////////////////////////
	//
	// @Inject is another alternative to overcome ambiguity
	// JSR 330 Standard
	//
	// ///////////////////////////////////////////////////////////////////
	
	public void javaSpecificationRequest330(String text) {
		injectWriter.writeJSR(text);
	}

	@PostConstruct
	public void initMe() {
		System.out.println("Created : " + this);
	}

	@PreDestroy
	public void destroyMe() {
		System.out.println("\nDestroyed : " + this);
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Alternative for init(): " + this + "\n");

	}

	public void destroy() {
		System.out.println("Alternative for destroy(): " + this);
	}
}
