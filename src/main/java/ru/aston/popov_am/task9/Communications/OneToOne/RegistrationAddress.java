package ru.aston.popov_am.task9.Communications.OneToOne;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String city;
    @NonNull
    private String street;
    @NonNull
    private String houseNumber;
    @NonNull
    private int apartmentNumber;

}
