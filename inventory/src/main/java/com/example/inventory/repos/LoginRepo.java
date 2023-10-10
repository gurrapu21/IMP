package com.example.inventory.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory.entity.Login;

public interface LoginRepo extends JpaRepository<Login, String> {

}
