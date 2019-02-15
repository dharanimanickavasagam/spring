package com.myspringlearnings.spring.annotations.annotations_bean_discovery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FileWriter implements LogWriter {

	public void write(String text) {
		System.out.println(text);

	}

}
