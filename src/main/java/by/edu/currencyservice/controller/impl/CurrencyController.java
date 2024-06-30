package by.edu.currencyservice.controller.impl;

import by.edu.currencyservice.controller.DocumentedCurrencyController;
import by.edu.currencyservice.dto.response.CurrencyResponse;
import by.edu.currencyservice.dto.response.FetchingResultResponse;
import by.edu.currencyservice.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/currencies")
@RequiredArgsConstructor
public class CurrencyController implements DocumentedCurrencyController {

    private final CurrencyService currencyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FetchingResultResponse fetchCurrenciesByDate(@RequestParam LocalDate date) {
        return currencyService.fetchCurrenciesByDate(date);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CurrencyResponse getCurrencyRateByCodeAndDate(
            @RequestParam String code,
            @RequestParam LocalDate date
    ) {
        return currencyService.getCurrencyRateByCodeAndDate(code, date);
    }
}
