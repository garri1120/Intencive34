package ru.aston.popov_am.task1.Model;

import java.math.BigDecimal;

public enum StateOfSupportedAutoParts {

    VERY_GOOD_CONDITION(new BigDecimal(10)),
    GOOD_CONDITION(new BigDecimal(20)),
    SATISFACTORY_CONDITION(new BigDecimal(30)),
    UNDER_RESTORATION_CONDITION(new BigDecimal(50)),
    REPAIR_KIT(new BigDecimal(70));
    private BigDecimal discountPercentage;

    StateOfSupportedAutoParts(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
