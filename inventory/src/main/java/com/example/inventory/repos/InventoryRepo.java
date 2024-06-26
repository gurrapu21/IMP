package com.example.inventory.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.inventory.entity.Inventory;

public interface InventoryRepo extends CrudRepository<Inventory, Integer> {
	
	public Inventory findByMaterialIdAndLocationNumber(String materialId, Long locationNumber);
	public List<Inventory> findAllByLocationNumber( Long locationNumber);
	
}
