package ru.aston.popov_am.task1.Interface_and_AbstractClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.aston.popov_am.task1.Model.User;
import java.math.BigDecimal;
@AllArgsConstructor
@Data
public abstract class AutoParts implements Discount {
    private BigDecimal autoPartsPrice;
    private User user;
    private int id;
}
