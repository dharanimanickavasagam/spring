package com.myspringlearnings.spring.annotations.annotations_basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		System.out.println("Annotations\n");

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/myspringlearnings/spring/annotations/annotations_basics/beans/beans.xml");

		Logger logger = (Logger) context.getBean("logger");
		// System.out.println(logger);

		logger.writeConsole("Hello from console");
		logger.writeFile("Hello from file");

		((ClassPathXmlApplicationContext) context).close();
	}
}
