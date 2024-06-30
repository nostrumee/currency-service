package by.edu.currencyservice.controller;

import by.edu.currencyservice.dto.response.CurrencyResponse;
import by.edu.currencyservice.dto.response.FetchingResultResponse;
import by.edu.currencyservice.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FetchingResultResponse fetchCurrenciesByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date
    ) {
        return currencyService.fetchCurrenciesByDate(date);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CurrencyResponse getCurrencyRateByCodeAndDate(
            @RequestParam String code,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date
    ) {
        return currencyService.getCurrencyRateByCodeAndDate(code, date);
    }
}
