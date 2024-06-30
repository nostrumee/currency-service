package by.edu.currencyservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record CurrencyApiResponse(
        @JsonProperty("Date")
        LocalDate date,

        @JsonProperty("Cur_Abbreviation")
        String code,

        @JsonProperty("Cur_OfficialRate")
        double rate
) {
}
