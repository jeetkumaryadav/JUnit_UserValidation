package com.capgemini.JUnit.Junit_UserValidation;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AppTest {
private boolean mailValid;
private String Email;

    static App app=null;
    
    public AppTest(String Email,boolean mailValid) {
    	super();
    	this.Email=Email;
    	this.mailValid=mailValid;
    	
    }
    
    
    @BeforeClass
    public static void setUp(){
    app=new App();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> input() {
    	return Arrays.asList(new Object[][] {{"abc@yahoo.com", true}, {"abc-100@yahoo.com",true},
    			{"abc.100@yahoo.com",true},
    			{"abc111@abc.com",true},
    			{"ac.100@abc.com.au",true},
    			{"abc@1.com",true},
    			{"abc@gmail.com.com",true},
    			{"abc+100@gmail.com",true}});
    	
    }
    @Test
    public void givenName_WhenProper_ShouldReturnTrue()
    {
        assertTrue("Invalid Name",app.validateName("Jeet"));
        assertFalse("Valid Name",app.validateName("eet"));
       
    }
    
    @Test
    public void givenEmail_WhenProper_ShouldReturnTrue()
    {
        assertTrue("Invalid Email",app.validateEmail(Email));
        assertFalse("Valid Email",app.validateEmail("jeetkrkr@jee.qw12"));
    }
    
    @Test
    public void givenMobile_WhenProper_ShouldReturnTrue()
    {
        assertTrue("Invalid Mobile No",app.validateMobile("91 9471129295"));
        assertFalse("Valid Mobile",app.validateMobile("7895622"));
    }
    
    @Test
    public void givenPassword_WhenProper_ShouldReturnTrue()
    {
        assertTrue("Invalid Password",app.validatePassword("jeetJEET@78"));
        assertFalse("Valid Password",app.validatePassword("jeetkrkr@jee.qw12"));
    }
}