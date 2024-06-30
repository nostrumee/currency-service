package by.edu.currencyservice.controller;

import by.edu.currencyservice.dto.response.CurrencyResponse;
import by.edu.currencyservice.dto.response.error.ErrorResponse;
import by.edu.currencyservice.dto.response.FetchingResultResponse;
import by.edu.currencyservice.dto.response.error.MultiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Tag(name = "Currency Controller", description = "Currency API")
public interface DocumentedCurrencyController {

    @Operation(summary = "Fetch currencies data from the NBRB API and save it to the database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201", description = "Currency data is successfully fetched",
                    content = {
                            @Content(schema = @Schema(implementation = FetchingResultResponse.class))
                    }),
            @ApiResponse(
                    responseCode = "409", description = "Currency data for the date is already fetched",
                    content = {
                            @Content(schema = @Schema(implementation = FetchingResultResponse.class))
                    }),
            @ApiResponse(
                    responseCode = "400", description = "Invalid date has been passed in the parameter",
                    content = {
                            @Content(schema = @Schema(implementation = MultiErrorResponse.class))
                    })
    })
    FetchingResultResponse fetchCurrenciesByDate(
            @Parameter(
                    description = "Date in yyyy-MM-dd format",
                    required = true,
                    example = "2022-01-10"
            ) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date
    );

    @Operation(summary = "Get rate for specified currency and date from the database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Currency rate is found",
                    content = {
                            @Content(schema = @Schema(implementation = CurrencyResponse.class))
                    }),
            @ApiResponse(
                    responseCode = "404", description = "Currency rate for this date or code not found",
                    content = {
                            @Content(schema = @Schema(implementation = ErrorResponse.class))
                    }),
            @ApiResponse(
                    responseCode = "400", description = "Invalid date has been passed in the parameter",
                    content = {
                            @Content(schema = @Schema(implementation = MultiErrorResponse.class))
                    })
    })
    CurrencyResponse getCurrencyRateByCodeAndDate(
            @Parameter(
                    description = "Abbreviation code of the currency",
                    required = true,
                    example = "USD"
            ) String code,
            @Parameter(
                    description = "Date in yyyy-MM-dd format",
                    required = true,
                    example = "2022-01-10"
            ) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date
    );
}
