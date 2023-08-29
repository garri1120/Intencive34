package ru.aston.popov_am.task1.Model;

import lombok.Data;
import ru.aston.popov_am.task1.Interface_and_AbstractClass.AutoParts;

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

    public BigDecimal getSupportedAutoPartsAmount(){
        BigDecimal d = this.getAutoPartsPrice().divide(this.getDiscount());
        return this.getAutoPartsPrice().subtract(d);
    }
    @Override
    public BigDecimal getDiscount() {
        return stateOfSupportedAutoParts.getDiscountPercentage();
    }
}
