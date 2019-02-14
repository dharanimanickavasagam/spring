package com.myspringlearnings.spring.bean_lists;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		System.out.println("Hello ");

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/myspringlearnings/spring/bean_lists/beans/beans.xml");

		Jungle jungle = (Jungle) context.getBean("jungle");
		System.out.println("\nLargest animal :" + jungle.getLargest());
		System.out.println(jungle);

		// INNER BEANS
		// Inner beans cannot be used as a reference outside the declared bean
		// belongs only to the outer bean
		// here lion is an inner bean & referenced by animal of type Animal

		System.out.println("\nInner Beans \nKing of the forest : "
				+ jungle.getKing());

		// PROPERTY MAPS
		// this contains a hashmap as a property
		System.out.println("\nProperty Map");
		JungleMap junglemap = (JungleMap) context.getBean("junglemap");
		System.out.println(junglemap);

		// PROPERTY BEAN MAPS
		// this contains bean reference to the hashmap
		System.out.println("Property Bean Map");
		JungleBeanMap junglebeanmap = (JungleBeanMap) context
				.getBean("junglebeanmap");
		System.out.println(junglebeanmap);

		((ClassPathXmlApplicationContext) context).close();
	}

}
