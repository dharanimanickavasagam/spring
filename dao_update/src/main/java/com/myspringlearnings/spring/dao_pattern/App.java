package com.myspringlearnings.spring.dao_pattern;

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

		} catch (CannotGetJdbcConnectionException e) {
			System.out.println("cannot get database connection");
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();

	}
}
