package by.edu.currencyservice.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response with the rate of specified currency")
public record CurrencyResponse(

        @Schema(name = "code", description = "Code abbreviation for the currency", example = "USD")
        String code,

        @Schema(name = "rate", description = "Rate of currency", example = "2.7101")
        double rate
) {
}
