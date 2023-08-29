package ru.aston.popov_am.task1.Model;

import java.math.BigDecimal;

public class SupportedAutoParts extends AutoParts {
    private StateOfSupportedAutoParts stateOfSupportedAutoParts;
    public SupportedAutoParts(BigDecimal autoPartsPrice, User user, int id, StateOfSupportedAutoParts stateOfSupportedAutoParts) {
        super(autoPartsPrice, user, id);
        this.stateOfSupportedAutoParts=stateOfSupportedAutoParts;
    }

    public StateOfSupportedAutoParts getStateOfSupportedAutoParts() {
        return stateOfSupportedAutoParts;
    }

    public void setStateOfSupportedAutoParts(StateOfSupportedAutoParts stateOfSupportedAutoParts) {
        this.stateOfSupportedAutoParts = stateOfSupportedAutoParts;
    }

    public BigDecimal getAutoPartsAmount(){
        BigDecimal discountAmount = this.getAutoPartsPrice().divide(new BigDecimal(100)).multiply(getDiscount());
        return this.getAutoPartsPrice().subtract(discountAmount);
    }
    @Override
    public BigDecimal getDiscount() {
        return stateOfSupportedAutoParts.getDiscountPercentage();
    }
}
