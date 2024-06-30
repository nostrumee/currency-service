package by.edu.currencyservice.controller;

import by.edu.currencyservice.dto.response.ErrorResponse;
import by.edu.currencyservice.dto.response.FetchingResultResponse;
import by.edu.currencyservice.exception.CurrencyDataAlreadyFetchedException;
import by.edu.currencyservice.exception.CurrencyDataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(CurrencyDataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCurrencyDataNotFound(CurrencyDataNotFoundException e) {
        return ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(CurrencyDataAlreadyFetchedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public FetchingResultResponse handleCurrencyDataAlreadyFetched(CurrencyDataAlreadyFetchedException e) {
        return FetchingResultResponse.builder()
                .message(e.getMessage())
                .build();
    }
}
