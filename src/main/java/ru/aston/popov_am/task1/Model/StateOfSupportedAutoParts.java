package ru.aston.popov_am.task1.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


public enum StateOfSupportedAutoParts {
    Very_good_condition(new BigDecimal(10)),
    Good_condition(new BigDecimal(20)),
    Satisfactory_condition(new BigDecimal(30)),
    Under_restoration_condition(new BigDecimal(50)),
    Repair_kit(new BigDecimal(70));
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
