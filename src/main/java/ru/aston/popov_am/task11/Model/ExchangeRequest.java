package ru.aston.popov_am.task11.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class ExchangeRequest {
    @JsonProperty("exchangeRate")
    private ExchangeRate exchangeRate;
    @JsonProperty("city")
    private String city;
    @JsonProperty("date")
    private String date;
    @JsonProperty("quantity")
    private BigDecimal quantity;
    @JsonProperty("result")
    private String result;
}
