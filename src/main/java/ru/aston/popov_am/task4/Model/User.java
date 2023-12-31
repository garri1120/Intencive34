package ru.aston.popov_am.task4.Model;

import lombok.*;

@Builder
@Data
public class User {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
}
