package com.example.microservices.InventoryService.repository;

import com.example.microservices.InventoryService.model.ItemStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<ItemStock,String> {

}
