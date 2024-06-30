package by.edu.currencyservice.service;

import by.edu.currencyservice.dto.response.CurrencyResponse;
import by.edu.currencyservice.dto.response.FetchingResultResponse;

import java.time.LocalDate;

public interface CurrencyService {

    FetchingResultResponse fetchCurrenciesByDate(LocalDate date);

    CurrencyResponse getCurrencyRateByCodeAndDate(String code, LocalDate date);
}
