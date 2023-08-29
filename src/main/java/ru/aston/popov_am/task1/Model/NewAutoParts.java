package ru.aston.popov_am.task1.Model;

import ru.aston.popov_am.task1.Interface_and_AbstractClass.AutoParts;

import java.math.BigDecimal;

public class NewAutoParts extends AutoParts {
    public NewAutoParts(BigDecimal autoPartsPrice, User user, int id) {
        super(autoPartsPrice, user, id);
    }

    public BigDecimal getSupportedAutoPartsAmount(){
        return new BigDecimal(0);
    }
    @Override
    public BigDecimal getDiscount() {
        return null;
    }
}
