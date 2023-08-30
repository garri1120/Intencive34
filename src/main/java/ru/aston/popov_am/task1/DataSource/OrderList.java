package ru.aston.popov_am.task1.DataSource;

import lombok.Data;
import ru.aston.popov_am.task1.Model.AutoParts;
import java.util.ArrayList;
import java.util.List;
@Data
public class OrderList{
    private List<AutoParts> autoPartsList;

    public OrderList() {
        autoPartsList = new ArrayList<>();
    }
}
