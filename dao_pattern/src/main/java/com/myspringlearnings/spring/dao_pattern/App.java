package com.myspringlearnings.spring.dao_pattern;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		System.out.println("Implementing DAO Pattern");

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/myspringlearnings/spring/dao_pattern/beans/beans.xml");

		// Offer offer = (Offer) context.getBean("offer");

		OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");
		List<Offer> list = offersDao.getOffers();
		
		for(Offer i : list) { 
			System.out.println(i);
		}

		((ClassPathXmlApplicationContext) context).close();

	}
}
