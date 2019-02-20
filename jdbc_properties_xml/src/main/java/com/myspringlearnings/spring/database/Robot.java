package com.myspringlearnings.spring.database;

public class Robot {

	private String id = "Default Robot";
	private String speech = "Hello";

	public void speak() {
		System.out.println("Robot id-" + id + " : " + speech);
	}

	public void setId(String id) {
		this.id = id;
		System.out.println("Injected id is " + id);
	}

	public void setSpeech(String speech) {
		this.speech = speech;
	}

	@Override
	public String toString() {
		return "Robot [id=" + id + ", speech=" + speech + "]";
	}

}
