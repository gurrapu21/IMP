package com.example.inventory.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.entity.RestInventor;

public interface EditInventoryRepo extends JpaRepository<RestInventor, Integer> {

}
