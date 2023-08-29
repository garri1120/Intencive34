package ru.aston.popov_am.task1.Model;
import lombok.*;

import java.util.Comparator;

@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class User implements Comparator<User> {
    private String name;
    private String sourName;
    private int age;
    @Override
    public int compare(User o1, User o2) {
        return o1.getSourName().compareTo(o2.getSourName());
    }
}
