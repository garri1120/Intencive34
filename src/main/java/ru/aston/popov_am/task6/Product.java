package ru.aston.popov_am.task6;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String name;
    private String category;
    private int price;
}
