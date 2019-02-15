package com.myspringlearnings.spring.annotations.annotations_bean_discovery;

import org.springframework.stereotype.Component;

@Component
public interface LogWriter {
	public void write(String text);
}
