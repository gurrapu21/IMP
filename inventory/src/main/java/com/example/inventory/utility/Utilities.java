package com.example.inventory.utility;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utilities {
	
	public String generateOTP() {
		return "" + new Random().nextInt((9999 - 100) + 1);
	}
}
