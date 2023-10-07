package ru.aston.popov_am.task11.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.popov_am.task11.AppError.NonExistentExchangeRate;
import ru.aston.popov_am.task11.AppError.NotFoundCity;
import ru.aston.popov_am.task11.Service.ExchangerImpl;


@RestController
@RequiredArgsConstructor
public class RestCont {
   private final ExchangerImpl exchangerImpl;


    @GetMapping("/{cityName}/{giveAwayTheCurrency}/{getCurrency}/{quantity}")
    public ResponseEntity<?> exchangerCurrency(@PathVariable String cityName,@PathVariable String giveAwayTheCurrency,@PathVariable String getCurrency,@PathVariable String quantity) throws NotFoundCity, NonExistentExchangeRate {

        return ResponseEntity.ok(exchangerImpl.currencyExchange(cityName,giveAwayTheCurrency,getCurrency,quantity));
    }
}
