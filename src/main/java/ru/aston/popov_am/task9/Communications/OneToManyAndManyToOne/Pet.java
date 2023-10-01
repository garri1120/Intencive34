package ru.aston.popov_am.task9.Communications.OneToManyAndManyToOne;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private SpeciesOfAnimal speciesOfAnimal;
    private String nickname;
    @ToString.Exclude
    @ManyToOne (fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="person_id", nullable=false)
    private Person person;
}
