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
        inventoryService.addItem(stockDto.getName(), stockDto.getQuantity(), stockDto.getPrice());
    }
}

