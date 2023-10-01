package ru.aston.popov_am.task9.OneTableForHierarchy;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@SuperBuilder
@ToString(callSuper = true)
@Data
@DiscriminatorValue("Cat")
@NoArgsConstructor
public class Cat extends Pet {
    private String breed;
    private String color;
}