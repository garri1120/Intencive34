package ru.aston.popov_am.task9.OneTableForClassAndImplicitPolymorphism;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.NonNull;
@EqualsAndHashCode(callSuper = true)
@Entity
@SuperBuilder
@Data
@NoArgsConstructor
public class CreditCard extends BillingDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @NonNull
    protected String cardNumber;
    @NonNull
    protected String expMonth;
    @NonNull
    protected String expYear;
}

