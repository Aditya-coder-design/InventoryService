package com.example.microservices.InventoryService.service;
import java.math.BigDecimal;
import java.util.stream.Collectors;
import com.example.microservices.InventoryService.DTO.StockDto;
import com.example.microservices.InventoryService.model.ItemStock;
import com.example.microservices.InventoryService.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // This service will handle the business logic for inventory management.
    // It will interact with the repository layer to perform CRUD operations on inventory items.
    public List<StockDto> getAllItems() {
        // Logic to fetch all items from the database
        // This will typically involve calling a repository method
        // and converting the entities to DTOs.
        List<ItemStock> allItems;
        try{
            allItems = inventoryRepository.findAll();
        }catch (Exception e){
            // Handle exception, log error, etc.
            e.printStackTrace();
            return List.of(); // Return an empty list in case of an error
        }

        // changing the branch to feature branch and just adding the comments here and there
        return   allItems.stream()
                       .map(item -> new StockDto(item.getItemName(), item.getQuantity(), item.getPrice()))
                       .collect(Collectors.toList());

    }

    @Transactional
    public void addItem(String name, int quantity, BigDecimal price) {
        // Logic to add a new item to the inventory
        ItemStock newItem = new ItemStock();
        newItem.setItemName(name);
        newItem.setQuantity(quantity);
        newItem.setPrice(price);
        inventoryRepository.save(newItem);
    }
    // Example method to get all items in the inventory
    // public List<StockDto> getAllItems() {
    //     // Logic to fetch all items from the database
    // }

    // Example method to add a new item to the inventory
    // public StockDto addItem(StockDto stockDto) {
    //     // Logic to save the new item to the database
    // }
    // Example method to update an existing item in the inventory
}
