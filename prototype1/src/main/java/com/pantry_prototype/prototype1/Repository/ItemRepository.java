package com.pantry_prototype.prototype1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pantry_prototype.prototype1.model.Items;

public interface ItemRepository extends JpaRepository<Items, Integer>{
}
