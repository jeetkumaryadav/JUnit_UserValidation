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
		boolean validate = Pattern.matches("^[A-Za-z0-9]+([.+-][A-Za-z0-9-]+)?@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)?(\\.[A-Za-z]{2,})$", email);
		return validate;
	}

	public boolean validateMobile(String mobile) {
		boolean validate = Pattern.matches("[0-9]{2}[ ][0-9]{10}", mobile);
		return validate;
	}

	public boolean validatePassword(String password) {
		boolean validate = Pattern.matches("(?=^.{8,}$)(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]*([^(A-Za-z0-9)]{1})[0-9a-zA-Z]*", password);
		return validate;
	}

	public static void main(String[] args)throws ValidityException {
		App app = new App();

		LOG.info("Enter the First Name:");
        String firstName = sc.next();
        try {
            if (!(app.validateName(firstName))) {
                throw new ValidityException("Invalid First Name");
            }
        } catch (ValidityException e) {
        }

        LOG.info("Enter the Last Name:");
        String lastName = sc.next();
        try {
            if (!(app.validateName(lastName))) {
                throw new ValidityException("Invalid Last Name");
            }
        } catch (ValidityException e) {
        }

        LOG.info("Enter the Email:");
        String email = sc.next();
        try {
            if (!(app.validateEmail(email))) {
                throw new ValidityException("Invalid Email");
            }
        } catch (ValidityException e) {
        }

        LOG.info("Enter the Mobile Number:");
        sc.nextLine();
        try {
            String mobile = sc.nextLine();
            if (!(app.validateMobile(mobile))) {
                throw new ValidityException("Invalid Mobile Number");
            }
        } catch (ValidityException e) {
        }

         LOG.info("Enter the Password:");
         String password = sc.next();
         try {
         if (!(app.validateMobile(password))) {
             throw new ValidityException("Invalid Password");
            }
        } catch (ValidityException e) {
        }

         LOG.info("All Exceptions Handled"); 
    }

}
