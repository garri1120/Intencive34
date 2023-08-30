package ru.aston.popov_am.task1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.aston.popov_am.task1.Interface.Discount;

import java.math.BigDecimal;
@AllArgsConstructor
@Data
public abstract class AutoParts implements Discount {
    private BigDecimal autoPartsPrice;
    private User user;
    private int id;
    public abstract BigDecimal getAutoPartsAmount();
}
