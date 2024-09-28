package com.supermarket.system.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    
    @Column(nullable=false)
    private String itemName;

    private double price;

    private Long categoryId;
}
