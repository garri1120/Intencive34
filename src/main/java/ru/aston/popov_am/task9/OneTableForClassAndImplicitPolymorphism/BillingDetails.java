package ru.aston.popov_am.task9.OneTableForClassAndImplicitPolymorphism;

import lombok.experimental.SuperBuilder;
import org.springframework.lang.NonNull;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Позволяет вынести общие поля в родительский класс, но при этом не создавать для него отдельную таблицу.
При такой стратегии классы-наследники преобразуются в независимые таблицы.
@MappedSuperclass никак не влияет на структуру в базе — это просто способ вынести общие поля.
 */
@Data
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public abstract class BillingDetails {

    @NonNull
    protected String owner;
}
