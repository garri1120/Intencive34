package ru.aston.popov_am.task11.CurrentExchangeRates;

import lombok.Data;
import ru.aston.popov_am.task11.Model.ExchangeRate;

import java.util.Map;
@Data
public class AvailableExchangeRates {
    Map<String,ExchangeRate> rates;
}
