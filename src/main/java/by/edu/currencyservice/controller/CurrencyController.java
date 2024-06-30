package by.edu.currencyservice.controller;

import by.edu.currencyservice.client.NbrbCurrencyClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final NbrbCurrencyClient currencyClient;

    @GetMapping
    public void fetchCurrenciesByDate(@RequestParam LocalDate date) {
        var list = currencyClient.getPosts(date);
        list.forEach(System.out::println);
    }
}
