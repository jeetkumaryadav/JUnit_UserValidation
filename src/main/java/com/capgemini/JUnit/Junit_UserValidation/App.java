package com.capgemini.JUnit.Junit_UserValidation;

import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	static Scanner sc = new Scanner(System.in);

	public boolean validateName(String name) {
		boolean validate = Pattern.matches("[A-Z]{1}[a-z]{2,}", name);
		return validate;
	}

	private static Logger LOG = LogManager.getLogger(App.class);
	
	public static void main(String[] args) {
		App app = new App();
		LOG.info("Enter the First Name:");
		String firstName = sc.next();
		while(!(app.validateName(firstName))){
			LOG.info("Invalid Entry. Enter the First Name:");
			firstName = sc.next();
		}
	}

}