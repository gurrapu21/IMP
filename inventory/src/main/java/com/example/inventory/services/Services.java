package com.example.inventory.services;

import java.util.List;

import com.example.inventory.entity.Inventory;
import com.example.inventory.entity.Login;
import com.example.inventory.entity.Orders;
import com.example.inventory.entity.RestInventor;
import com.example.inventory.model.Registration;

public interface Services {
	
	public String authentication(Login login);
	public boolean registration(Registration registration);
	public String editInventory(RestInventor restInventor);
	public String acceptOrders(String userId,Orders orders);
	public Boolean triggerEmail(String email, String message);
	public List<Inventory> getInventorys(Long locnum);
	public Inventory getInventory(Long locnum, String matId);
	public List<Orders> getOrders(String userId);
	public String addItem(Inventory item);
	public String forgotPasswrod(String userId);
	public String changePassword(String userId,String pw);
	
	
}
