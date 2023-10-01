package ru.aston.popov_am.task9.OneTableForEveryoneClassWithUnions;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
public class Dog extends Animal{
    @Column(nullable = false)
    private String breed;
}
/*
при такой стратегии наследования необходимо использовать @Column(nullable = false) чтобы запретить null.
 */