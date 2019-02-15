package com.myspringlearnings.spring.annotations.annotations_setting_values;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {

	private int id = 0;
	private String speech = "Hello";

	public void speak() {
		System.out.println("Robot id-" + id + " : " + speech);
	}

	@Inject
	public void setId(@Value("7") int id) {
		this.id = id;
		System.out.println("Injected id is " + id);
	}
	
	@Autowired
	public void setSpeech(@Value("Hi Dharu") String speech) {
		this.speech = speech;
	}

	@Override
	public String toString() {
		return "Robot [id=" + id + ", speech=" + speech + "]";
	}

}
