package com.myspringlearnings.spring.beans_basics;

public class PersonFactory {
	public Person createPerson(int id, String name) {
		// factory-bean: represents the reference of the bean by which factory
		// method will be invoked. It is used if factory method is non-static

		System.out
				.println("\nCreating a new Person obj from factory method of factory class ");
		return new Person(id, name);
	}

}
