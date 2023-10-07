package ru.aston.popov_am.task11.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aston.popov_am.task11.AppError.NonExistentExchangeRate;
import ru.aston.popov_am.task11.AppError.NotFoundCity;
import ru.aston.popov_am.task11.CurrentExchangeRates.AvailableExchangeRates;
import ru.aston.popov_am.task11.Model.City;
import ru.aston.popov_am.task11.Model.ExchangeRate;
import ru.aston.popov_am.task11.Model.ExchangeRequest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class ExchangerImpl implements Exchanger{
    private final AvailableExchangeRates availableExchangeRates;


    @Override
    public ExchangeRequest currencyExchange(String cityName,String giveAwayTheCurrency,String getCurrency,String quantity) throws NotFoundCity, NonExistentExchangeRate {
        Set<String> cityEnum = City.getAllCity();

        if(!cityEnum.contains(cityName)) throw new NotFoundCity("В этом городе нет обменника");

        String rateCity = giveAwayTheCurrency + "-" + getCurrency;

        Map<String,ExchangeRate> exchangeRateMap = availableExchangeRates.getRates();

        if(!exchangeRateMap.containsKey(rateCity)) throw new NonExistentExchangeRate("Такого курса обмена не существует");

        ExchangeRequest exchangeRequest = ExchangeRequest.builder()
                .exchangeRate(
                        exchangeRateMap.get(rateCity))
                .city(cityName)
                .date(LocalDate.now().toString())
                .quantity(new BigDecimal(quantity))
                .build();

        // получить сумму для обмена + узнать курс между валютами + перемножить + узнать ставку для конкретного города и на нее умножить

        exchangeRequest.setResult(exchangeRequest.getQuantity().multiply(exchangeRequest.getExchangeRate().getRate()).multiply(new BigDecimal(City.valueOf(exchangeRequest.getCity()).getRateCity())).toString());

        return exchangeRequest;
    }
}
