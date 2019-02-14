package com.myspringlearnings.spring.beans_basics;

public class Person {
	private int id;
	private String name;
	private int taxId;
	private int age;
	private Address address;

	public Person() {

	}

	// create a factory method to do dependency injection
	// factory method - returns instance of the class
	// used to replace a private constructor - as it cannot be invoked for obj
	// creation. It should be static and public

	public static Person getInstance(int id, String name) {
		System.out.println("\nCreating a new Person obj from factory method ");
		return new Person(id, name);
	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", taxId=" + taxId
				+ ", age=" + age + ", address=" + address + "]";
	}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void onCreate() {
		System.out.println("Person Created : " + this);
	}

	public void onDestroy() {
		System.out.println("Person Destroyed : " + this);
	}

}
