package com.example.inventory.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.entity.Orders;

public interface OrderRepo extends JpaRepository<Orders,Integer > {
	List<Orders> findAllByUserId(String userId);
}
