package com.myspringlearnings.spring.annotations.annotations_bean_discovery;

import org.springframework.stereotype.Component;

@Component
public class ResourceWriter {

	public void writeJSR(String text) {
		System.out.println(text);
	}
}
