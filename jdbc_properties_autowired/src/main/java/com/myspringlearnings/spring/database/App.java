package com.myspringlearnings.spring.database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		System.out.println("Setting values for annotations using @Value");

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/myspringlearnings/spring/database/beans/beans.xml");

		Robot robot = (Robot) context.getBean("robot");
		System.out.println(robot);

		robot.speak();
	}

}
