package ru.aston.popov_am.task9.Communications.OneToOne;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String firstname;
    @NonNull
    private String lastname;
    @OneToOne(
            cascade = CascadeType.ALL, // Все действия, которые выполняются с родительским объектом, нужно повторить и для его зависимых объектов.
            fetch = FetchType.LAZY, // ленивая загрузка
            optional = false // запрет null для адреса регистрации
    )
    @JoinColumn(name = "registrationAddress_id")
    private RegistrationAddress registrationAddress;
}
