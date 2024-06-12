package com.pantry_prototype.prototype1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pantry_prototype.prototype1.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> { 
} 