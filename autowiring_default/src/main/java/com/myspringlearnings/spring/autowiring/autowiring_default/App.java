package com.myspringlearnings.spring.autowiring.autowiring_default;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		System.out.println("Autowiring - Setting the defaults\n");

		// ////////////////////////////////////////////////////////////////////
		//
		// Autowiring is a concept where spring tries to figure out dependencies
		// between beans on its own
		// spring will instantiate the beans on the order of dependency
		//
		// We can also do this manually - wire up beans manually
		// Logger Class has 2 props
		// 1.ConsoleWriter
		// 2.FileWriter
		//
		// above are 2 separate dependencies that should be injected to Logger,
		// so inject them with a setter
		//
		//
		// /////////////////////////////////////////////////////////////////////

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/myspringlearnings/spring/autowiring/autowiring_default/beans/beans.xml");

		Logger logger = (Logger) context.getBean("logger");
		logger.writeConsole("Hello from Console");
		logger.writeFile("Hello from File");

	}

}
