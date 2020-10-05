package com.capgemini.JUnit.Junit_UserValidation;

import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	private static Logger LOG = LogManager.getLogger(App.class);
	static Scanner sc = new Scanner(System.in);

	public boolean validateName(String name) {
		boolean validate = Pattern.matches("[A-Z]{1}[a-z]{2,}", name);
		return validate;
	}

	public boolean validateEmail(String email) {
		boolean validate = Pattern
				.matches("^[A-Za-z0-9]+(\\.[A-Za-z0-9-]+)?@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)?(\\.[A-Za-z]{2,})$", email);
		return validate;
	}

	public boolean validateMobile(String mobile) {
		boolean validate = Pattern.matches("[0-9]{2}[ ][0-9]{10}", mobile);
		return validate;
	}

	public boolean validatePassword(String password) {
		boolean validate = Pattern.matches("(?=^.{8,}$)(?=.[A-Z])(?=.[0-9])[a-zA-Z0-9]*([^(A-Za-z0-9 )]{1})[0-9a-zA-Z]*", password);
		return validate;
	}

	public static void main(String[] args) {
		App app = new App();

		LOG.info("Enter the First Name:");
		String firstName = sc.next();
		while (!(app.validateName(firstName))) {
			LOG.info("Invalid Entry. Enter the First Name:");
			firstName = sc.next();
		}

		LOG.info("Enter the Last Name:");
		String lastName = sc.next();
		while (!(app.validateName(lastName))) {
			LOG.info("Invalid Entry. Enter the Last Name:");
			lastName = sc.next();
		}

		LOG.info("Enter the Email:");
		String email = sc.next();
		while (!(app.validateEmail(email))) {
			LOG.info("Invalid Entry. Enter the Email:");
			email = sc.next();
		}
        sc.nextLine();
		LOG.info("Enter the Mobile Number:");
		String mobile = sc.nextLine();
		while (!(app.validateMobile(mobile))) {
			LOG.info("Invalid Entry. Enter the Mobile Number:");
			mobile = sc.next();
		}

		LOG.info("Enter the Password:");
		String password = sc.next();
		while (!(app.validateMobile(password))) {
			LOG.info("Invalid Entry. Enter the Password:");
			password = sc.next();
		}

}
}