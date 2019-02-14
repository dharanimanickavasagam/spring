package com.myspringlearnings.spring.beans_basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		System.out.println("Welcome to basics of bean..");
		System.out
				.println("\nperson1 uses factory-method \nperson2 uses factory-bean");
		// Creating IoC container to create and instantiate beans
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/myspringlearnings/spring/beans_basics/beans/beans.xml");

		Person person = (Person) context.getBean("person");
		person.setTaxId(100);

		Address address = (Address) context.getBean("address1");
		System.out.println("\nAddress is : "+address);

		System.out.println("\nThe End");

		((ClassPathXmlApplicationContext) context).close();

	}
}
