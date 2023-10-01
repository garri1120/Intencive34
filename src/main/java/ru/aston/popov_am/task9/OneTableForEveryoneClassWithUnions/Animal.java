package ru.aston.popov_am.task9.OneTableForEveryoneClassWithUnions;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;
    @Column(nullable = false)
    private String nickname;
}
/*
 Cуперклассе должны иметься идентификатор в базе данных и его отображение, чтобы все подклассы могли использовать его в своих таблицах.
 Так же для id не должна быть strategy = GenerationType.IDENTITY
 */