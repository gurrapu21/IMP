package com.example.inventory.validations;

import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.inventory.model.Registration;

public class UserValidation {
	
	public static String validateUser(Registration user) {
		
		String msg = "";
	
		Matcher userNameM = Pattern.compile( "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$").matcher(user.getName());
		Matcher phoneNumM= Pattern.compile("\\d{10}").matcher(user.getPhone());
		int age = Period.between(new java.sql.Date( user.getDob().getTime() )
                .toLocalDate(), new java.sql.Date( new java.util.Date().getTime() )
                .toLocalDate()).getYears();  
	    System.out.println(user.getPhone());
	    if(!userNameM.matches()) {
	    	msg = "Name should only contains aphabets and spaces";
	    }else if(!phoneNumM.matches()) {
	    	msg = "Phone Number should only be 10 digits";
	    }else if(age < 18) {
	    	msg = "Sorry User Should be above 18";
	    }
	    
	    return msg;
	}
	  
}
