package ru.aston.popov_am.task11.Service;

import ru.aston.popov_am.task11.AppError.NonExistentExchangeRate;
import ru.aston.popov_am.task11.AppError.NotFoundCity;
import ru.aston.popov_am.task11.Model.ExchangeRequest;


public interface Exchanger {
    ExchangeRequest currencyExchange(String cityName,String giveAwayTheCurrency,String getCurrency,String rate) throws NotFoundCity, NonExistentExchangeRate;
}
