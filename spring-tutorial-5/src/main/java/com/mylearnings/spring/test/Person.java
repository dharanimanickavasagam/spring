package com.mylearnings.spring.test;

public class Person {
	private int id;
	private String name;
	private int taxId;
	private int age;

	// Address address is a dependency injected
	// to add the dependency
	// 1. either add the address in the constructor
	// 2. define a setter to it
	private Address address;

	public Person() {
	}

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public int getTaxId() {
		return taxId;
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

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", taxId=" + taxId
				+ ", age=" + age + ", address=" + address + "]";
	}

	public void speak() {
		System.out.println("Hello, I am a person");
	}

	public void onCreate() {
		System.out.println("Person created : " + this);
	}

	public void onDestroy() {
		System.out.println("Person destroyed : " + this);
	}
	
	public void init() { 
		System.out.println("Default");
	}
	public void destroy() { 
		System.out.println("Default");
	}
}
