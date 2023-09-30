package ru.aston.popov_am.task9.OneTablePerSubclassUsingConnections;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class ProductDairy extends Product{
    @Column(nullable = false)
    private double fatContent;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Dairy dairy;

}
