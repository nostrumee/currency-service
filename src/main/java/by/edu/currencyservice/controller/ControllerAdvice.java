package by.edu.currencyservice.controller;

import by.edu.currencyservice.dto.response.error.ErrorResponse;
import by.edu.currencyservice.dto.response.FetchingResultResponse;
import by.edu.currencyservice.dto.response.error.MultiErrorResponse;
import by.edu.currencyservice.exception.CurrencyDataAlreadyFetchedException;
import by.edu.currencyservice.exception.CurrencyDataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

import static by.edu.currencyservice.util.Messages.HTTP_MESSAGE_NOT_READABLE_MESSAGE;
import static by.edu.currencyservice.util.Messages.VALIDATION_FAILED_MESSAGE;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MultiErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        var errors = new HashMap<String, String>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return MultiErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(VALIDATION_FAILED_MESSAGE)
                .errors(errors)
                .build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleHttpMessageNotReadable(HttpMessageNotReadableException e) {
        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(HTTP_MESSAGE_NOT_READABLE_MESSAGE)
                .build();
    }
}
