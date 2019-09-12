package com.testing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hello {

	// This particular variable is loaded when the object is created
	@Value("${message}")
	String messageFromConfigFile;
	
	public Hello() {
		System.out.println("hello class loaded" + messageFromConfigFile);
	}
	
	public void Display() {
		System.out.println(messageFromConfigFile);
	}
	
}