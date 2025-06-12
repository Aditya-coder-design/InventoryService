package com.example.microservices.InventoryService.controller;

import com.example.microservices.InventoryService.DTO.StockDto;
import com.example.microservices.InventoryService.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/getItems")
    public ResponseEntity<List<StockDto>> getItems() {
        return ResponseEntity.ok(inventoryService.getAllItems());
    }

    @PostMapping("/addItem")
    public void addItem(@RequestBody StockDto stockDto) {
        //adding comment to clarify that this method adds an item to the inventory


        // changin the branch to feature branch and just adding the comments here and there
        inventoryService.addItem(stockDto.getName(), stockDto.getQuantity(), stockDto.getPrice());
    }
}

