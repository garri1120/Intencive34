package ru.aston.popov_am.task4.Model;

import lombok.*;

@Builder
@AllArgsConstructor
@EqualsAndHashCode
@Data
@ToString
public class Order {
    private int id;
    private String product;
    private int price;
    private int userId;
}
