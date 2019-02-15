package com.myspringlearnings.spring.annotations.annotations_bean_discovery;

import javax.inject.Inject;

import javax.inject.Named;

import org.springframework.stereotype.Component;

@Component
public class InjectWriter {

	public void writeJSR(String text) {
		System.out.println(text);
	}

}
