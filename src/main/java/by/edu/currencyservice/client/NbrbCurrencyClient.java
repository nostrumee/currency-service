package by.edu.currencyservice.client;

import by.edu.currencyservice.persistence.entity.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient("nbrb-currency-client")
public interface NbrbCurrencyClient {

    @GetMapping
    List<Currency> getCurrencies(@RequestParam("ondate") LocalDate date);

}
