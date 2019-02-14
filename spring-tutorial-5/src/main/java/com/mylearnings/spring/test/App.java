package com.mylearnings.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		// It is a Bean Container class that instantiates the beans(normal java
		// objects) and fetches the beans from these containers
		// below code creates the Spring bean container
		// use the container to get the beans from it

		// It is a good practice to create a package for the beans and put the
		// beans.xml in it as spring might use many XMLs

		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/java/com/mylearnings/spring/test/beans/beans.xml");

		// Normal invocation without spring
		// Person person = new Person();
		// person.speak();

		// Pass the id of the bean to be fetched
		Person person = (Person) context.getBean("person");
		System.out.println("Spring starts ");
		person.speak();

		// //////////////////////////////////////////////////////////////////////////////

		System.out.println("\nRedoing the above with classpath..");

		// ClassPathXmlApplicationContext
		ApplicationContext context1 = new ClassPathXmlApplicationContext(
				"com/mylearnings/spring/test/beans/beans.xml");
		System.out.println("Spring starts ");
		Person person1 = (Person) context1.getBean("person");
		person1.speak();

		// What happens ?
		// FileSystemXmlApplicationContext opens beans.xml
		// There Person class is mapped with an id person
		// Finds the Person class mentioned in the XML file
		// It instantiates and fetches the object from this context
		// We can now call the speak() of Person

		System.out.println("\nGenerating Person constructor with arguments");
		// cannot create a person object since the id,name are not defined
		// so put up a default constructor Person()

		// In beans.xml, do either one (value is must in case 1 to 3)
		// 1. specify the values for the constructor arg
		// 2. specify name or index(or both) and values for the constructor arg
		// 3. specify type and value
		// 4. ref allows to do dependency injection, specify some other bean as
		// value

		// Adding a setter method - Method 1
		// to add a variable used in the setter of Person class into beans.xml
		// right click on Person in beans.xml > add property
		// set the name and value
		System.out.println("\nDefining a Setter method");
		System.out.println("Tax id is : " + person1.getTaxId());

		// Adding a setter method - Method 2
		// You can also add value in beans.xml
		// go inside <property> and then hit ctrl + space
		// choose value and give a value
		System.out.println("\nDefininig value as sub tag in beans.xml");
		System.out.println("Age is : " + person1.getAge());

		// Adding a new Class and creating a new bean
		// instantiating and calling toString()
		System.out.println("\nCreating a new class and a bean");
		Address address = (Address) context.getBean("address");
		System.out.println(address);

		// dependency is injected by adding Address setter in Person
		// set property address with value as Address class location in
		// beans.xml

		System.out.println(person1);

		// ///////////////////////////////////////////////////////////////////////////////////////
		//
		// At this time of writing there are 2 Person objects
		// person,person1 are in different IoC containers, scope are singleton
		// so creating new person2,person3 objects
		// default scope : singleton
		// singleton - returns the cached bean if the bean is already existing

		// /////////////////////////////////////////////////////////////////////////////////////

		System.out.println("\nScope of a bean"
				+ "\nChanging the scope of Person to singleton");

		Person person2 = (Person) context.getBean("person");
		Person person3 = (Person) context.getBean("person");

		person2.setAge(10);
		System.out.println(person);
		System.out.println(person2);
		System.out.println(person3 + "\n");

		// change the scope of the person bean to prototype to create new
		// objects for Person and repeat the above

		// /////////////////////////////////////////////////////////////////////////////////////
		//
		// Beans have a life cycle
		// When a IoC is created, init() is called
		// destroy() is called before IoC destroy
		//
		// map the init() and the destroy() methods in the beans.xml
		// if defaults are specified and beans have local init() and destroy(),
		// precedence is local bean
		// if the defaults is set and if the local bean has the methods defined,
		// init() and destroy() are invoked
		//
		// instead of setting init() and destroy() for each bean in beans.xml,
		// set defaults, so that they are called automatically
		//
		// Scope
		// Singleton : init() and destroy()
		// prototype : init()
		//
		// /////////////////////////////////////////////////////////////////////////////////////
		
		
		
		((FileSystemXmlApplicationContext) context).close();
		((ClassPathXmlApplicationContext) context1).close();
	}
}
