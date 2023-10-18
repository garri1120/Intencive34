package ru.aston.popov_am.task11.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.aston.popov_am.task11.CurrentExchangeRates.AvailableExchangeRates;
import ru.aston.popov_am.task11.Model.ExchangeRate;
import ru.aston.popov_am.task11.Model.MyCurrency;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ExchangeConfig {
    @Bean
    public AvailableExchangeRates getRates(){
        AvailableExchangeRates availableExchangeRates = new AvailableExchangeRates();
        Map<String,ExchangeRate> rates = new HashMap<>();
        rates.put("RUB-EUR",ExchangeRate.builder().giveAwayTheCurrency(MyCurrency.RUB.name()).getCurrency(MyCurrency.EUR.name()).rate(new BigDecimal("0.006")).build());
        rates.put("RUB-USD",ExchangeRate.builder().giveAwayTheCurrency(MyCurrency.RUB.name()).getCurrency(MyCurrency.USD.name()).rate(new BigDecimal("0.01")).build());
        rates.put("USD-RUB",ExchangeRate.builder().giveAwayTheCurrency(MyCurrency.USD.name()).getCurrency(MyCurrency.RUB.name()).rate(new BigDecimal("100")).build());
        rates.put("USD-EUR",ExchangeRate.builder().giveAwayTheCurrency(MyCurrency.USD.name()).getCurrency(MyCurrency.EUR.name()).rate(new BigDecimal("0.9")).build());
        rates.put("EUR-RUB",ExchangeRate.builder().giveAwayTheCurrency(MyCurrency.EUR.name()).getCurrency(MyCurrency.RUB.name()).rate(new BigDecimal("140")).build());
        rates.put("EUR-USD",ExchangeRate.builder().giveAwayTheCurrency(MyCurrency.EUR.name()).getCurrency(MyCurrency.USD.name()).rate(new BigDecimal("1.1")).build());

        availableExchangeRates.setRates(rates);

        return availableExchangeRates;
    }
}
