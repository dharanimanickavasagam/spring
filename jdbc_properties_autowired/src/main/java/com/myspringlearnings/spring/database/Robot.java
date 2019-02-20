package com.myspringlearnings.spring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {

	private String id = "Default Robot";
	private String speech = "Hello";

	public void speak() {
		System.out.println("Robot id-" + id + " : " + speech);
	}

	@Autowired
	public void setId(@Value("${jdbc.user}") String id) {
		this.id = id;
		System.out.println("Injected id is " + id);
	}

	@Autowired
	public void setSpeech(@Value("${jdbc.password}") String speech) {
		this.speech = speech;
	}

	@Override
	public String toString() {
		return "Robot [id=" + id + ", speech=" + speech + "]";
	}

}
