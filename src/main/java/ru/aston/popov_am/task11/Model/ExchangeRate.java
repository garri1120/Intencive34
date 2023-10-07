package ru.aston.popov_am.task11.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@Builder
public class ExchangeRate {
    @JsonProperty("giveAwayTheCurrency")
    private String giveAwayTheCurrency;
    @JsonProperty("getCurrency")
    private String getCurrency;
    @JsonProperty("rate")
    private BigDecimal rate;
}
