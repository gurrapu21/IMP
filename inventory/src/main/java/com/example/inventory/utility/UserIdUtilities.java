package com.example.inventory.utility;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.example.inventory.repos.UserRepo;

@Component

public class UserIdUtilities {

//	@Autowired
//	UserRepo repo;
	public String generateUserId(UserRepo repo) {
		boolean flag = true;
		String userId="R-";
		while(flag) {
			Random random=new Random();
			int threedigit=random.nextInt(900)+100;
			 userId=userId+threedigit;
			if(!repo.findByUserId(userId).isPresent()) {
				flag=false;
			}
			
			
		}
		return userId;
		
	}
}
