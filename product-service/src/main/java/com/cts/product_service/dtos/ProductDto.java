package com.cts.product_service.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"id","name","description","price","quantity"})
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
}