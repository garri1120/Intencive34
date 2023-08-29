package ru.aston.popov_am.task1.Model;

import java.math.BigDecimal;

public class NewAutoParts extends AutoParts {
    public NewAutoParts(BigDecimal autoPartsPrice, User user, int id) {
        super(autoPartsPrice, user, id);
    }

    public BigDecimal getAutoPartsAmount(){
        return getAutoPartsPrice();
    }
    @Override
    public BigDecimal getDiscount() {
        return new BigDecimal(0);
    }
}
