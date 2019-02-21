package com.myspringlearnings.spring.dao_pattern;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {
	public static void main(String[] args) {
		System.out.println("Implementing DAO Pattern");

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/myspringlearnings/spring/dao_pattern/beans/beans.xml");

		// We don't handle any exceptions manually
		// Spring handles all exceptions when connecting with DB
		// It wraps them in DataAcccessException - its a run time handler

		System.out.println("\nGetting specific offer");
		try {
			OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");

			List<Offer> listNamedParam = offersDao.getAllOffers();
			for (Offer i : listNamedParam) {
				System.out.println(i);
			}

			System.out.println("\nRequesting a row based on ID :2");
			Offer offer = offersDao.getSpecifiedOffer(2);
			System.out.println(offer);

			System.out.println("\nDeleting a row from offers");
			System.out.println("A row deleted ? " + offersDao.delete(6));

			System.out.println("\nCreating a row for offers");
			Offer offer1 = new Offer("Dave", "dave@gh", "coder");
			System.out.println("A row Created ? " + offersDao.create(offer1));

			System.out.println("\nUpdating a row of offers");
			System.out.println("Updated ? " + offersDao.update(10));

			System.out.println("\nInserting few rows using Batch updates  ");
			List<Offer> offers = new ArrayList<Offer>();

			offers.add(new Offer("monica", "monica@gh", "Chef"));
			offers.add(new Offer("joey", "joey@gh", "Actor"));

			int rvals[] = offersDao.create(offers);
			for (int val : rvals) {
				System.out.println(val);
			}

		} catch (CannotGetJdbcConnectionException e) {
			System.out.println("cannot get database connection");
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();

	}
}
