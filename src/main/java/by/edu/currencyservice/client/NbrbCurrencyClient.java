package by.edu.currencyservice.client;

import by.edu.currencyservice.dto.response.CurrencyApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient("nbrb-currency-client")
public interface NbrbCurrencyClient {

    @GetMapping
    List<CurrencyApiResponse> getCurrencies(
            @RequestParam("ondate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date
    );

}
