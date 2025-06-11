package com.example.microservices.InventoryService.DTO;


// This class is a Data Transfer Object (DTO) for items in the inventory service.

import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StockDto {

    private String name;
    private int quantity;
    private BigDecimal price;

}
