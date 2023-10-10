package com.example.inventory.services;

import com.example.inventory.entity.EmailDetails;

public interface EmailServices {
	
		 
	    // Method
	    // To send a simple email
	    boolean sendSimpleMail(EmailDetails details);
	 
	    // Method
	    // To send an email with attachment
	    String sendMailWithAttachment(EmailDetails details);
	
}
