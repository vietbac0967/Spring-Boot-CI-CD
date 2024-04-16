package com.bac.se.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
    private int id;
    private String name;
    private double price;
    private LocalDate createAt;
}
