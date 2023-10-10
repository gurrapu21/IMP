package com.example.inventory.servicesimpl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.entity.EmailDetails;
import com.example.inventory.entity.Inventory;
import com.example.inventory.entity.Login;
import com.example.inventory.entity.Orders;
import com.example.inventory.entity.RestInventor;
import com.example.inventory.entity.Users;
import com.example.inventory.model.Registration;
import com.example.inventory.repos.EditInventoryRepo;
import com.example.inventory.repos.InventoryRepo;
import com.example.inventory.repos.LoginRepo;
import com.example.inventory.repos.OrderRepo;
import com.example.inventory.repos.UserRepo;
import com.example.inventory.services.EmailServices;
import com.example.inventory.services.Services;
import com.example.inventory.utility.UserIdUtilities;
import com.example.inventory.utility.Utilities;

import net.bytebuddy.utility.RandomString;

@Service
public class ServicesImplementation implements Services {

	@Autowired
	LoginRepo loginrepo;

	@Autowired
	UserRepo userrepo;

	@Autowired
	EditInventoryRepo restrepo;

	@Autowired
	OrderRepo orderrepo;

	@Autowired
	InventoryRepo inventoryrepo;
	
	@Autowired 
	private EmailServices emailService;
	
	@Autowired
	Utilities util;
	
	@Override
	public String authentication(Login login) {
		// TODO Auto-generated method stub

		Login logindetails = loginrepo.findById(login.getUserId()).get();

		if (logindetails.getPassword().equals(login.getPassword())) {
			return userrepo.findByUserId(logindetails.getUserId()).get().getRole()+"@"+userrepo.findByUserId(logindetails.getUserId()).get().getName();
		}
		
		
		
		return "Invalid UserId or Password";
	}

	@Override
	public boolean registration(Registration registration) {
		// TODO Auto-generated method stub
		UserIdUtilities useridutil = new UserIdUtilities();
		String userId = useridutil.generateUserId(userrepo);
		Users user = new Users(userId, registration.getName(), registration.getPhone(), registration.getEmail(),
				registration.getRole(), registration.getDob());
		userrepo.save(user);
		Login login = new Login(userId, registration.getPassword());
		loginrepo.save(login);
		
		EmailDetails details = new EmailDetails(registration.getEmail(),"Hi "+ registration.getName() +",\n\nYour User ID is " + userId +". \n\n use this to Login\n\n\nThank you.", "User ID to Login");
		
		
		boolean status = emailService.sendSimpleMail(details);
		
		return status;
	}

	@Override
	public String editInventory(RestInventor restInventor) {
		// TODO Auto-generated method stub

		restrepo.save(restInventor);

		Inventory inventory = inventoryrepo.findByMaterialIdAndLocationNumber(restInventor.getMaterialId(),
				restInventor.getLocationNumber());

		inventory.setResetQty(restInventor.getResetQty());
		inventory.setAvailableQuantity(inventory.getResetQty() - inventory.getOrderQuantity());

		inventoryrepo.save(inventory);

		return "Updated!!!";
	}

	@Override
	public String acceptOrders(String userId, Orders orders) {
		// TODO Auto-generated method stub

		orderrepo.save(orders);
		Inventory inventory = inventoryrepo.findByMaterialIdAndLocationNumber(orders.getMaterialId(),
				orders.getLocationNumber());
		
		inventory.setOrderQuantity(inventory.getOrderQuantity()+orders.getOrderQuantity());
		inventory.setAvailableQuantity(inventory.getResetQty() - inventory.getOrderQuantity());

		inventoryrepo.save(inventory);
		
		EmailDetails details = new EmailDetails(userrepo.findByUserId(userId).get().getEmail(),"Your order for " + orders.getMaterialId() +" is Successful\n" + orders,"Confirmation of Order");
		
		
		boolean status = emailService.sendSimpleMail(details);

		return status ? "Order Successful!!! :>" : "Order not Successfull :(";

	}

	@Override
	public Boolean triggerEmail(String email, String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventory> getInventorys(Long locnum) {

		return inventoryrepo.findAllByLocationNumber(locnum);

	}

	@Override
	public Inventory getInventory(Long locnum, String matId) {
		return inventoryrepo.findByMaterialIdAndLocationNumber(matId, locnum);
	}

	@Override
	public List<Orders> getOrders(String userId) {
		
		List<Orders> orders = orderrepo.findAllByUserId(userId);
		
		return orders;
	}
	
	@Override
	public String addItem(Inventory item) {
		
		
		item.setId((int)inventoryrepo.count()+1);
		System.out.println(item);
		inventoryrepo.save(item);
		
		return "Item added to the Inventory Successfully!!";
		
	}

	@Override
	public String forgotPasswrod(String userId) {
		// TODO Auto-generated method stub
		
		Users user = (Users) userrepo.findByUserId(userId).get();
		
		System.out.println(user);
		
		String otp = util.generateOTP();
		
		
		
		EmailDetails details = new EmailDetails(user.getEmail(),"Hi "+ user.getName() +",\n\nYour OTP to Reset the Password : " + otp +" \n\n\n\nThank you.", "OTP");
		
		
		boolean status = emailService.sendSimpleMail(details);
		
		
		return status ? otp : null;
	}
	
	public String changePassword(String userId,String password) {
		
		Login login = loginrepo.getById(userId);
		login.setPassword(password);
		
		loginrepo.save(login);
		return "Password changed successfully!!";
		
	}
	
	
}
