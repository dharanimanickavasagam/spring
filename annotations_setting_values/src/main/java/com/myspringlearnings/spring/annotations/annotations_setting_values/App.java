package com.myspringlearnings.spring.annotations.annotations_setting_values;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		System.out.println("Setting values for annotations using @Value");

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/myspringlearnings/spring/annotations/annotations_setting_values/beans/beans.xml");
		
		
		Robot robot = (Robot) context.getBean("robot");
		System.out.println(robot);
		
		robot.speak();
	}

}
