package com.myspringlearnings.spring.listing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		System.out.println("Setting List Properties\n");

		// Creating IoC container to create and instantiate beans
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/myspringlearnings/spring/listing/beans/beans.xml");
		
		FruitBasket basket = (FruitBasket) context.getBean("fruitbasket");
		System.out.println(basket);
		

	}
}
