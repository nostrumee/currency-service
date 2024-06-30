package by.edu.currencyservice.controller;

import by.edu.currencyservice.dto.response.FetchingResultResponse;
import by.edu.currencyservice.dto.response.error.ErrorResponse;
import by.edu.currencyservice.dto.response.error.MultiErrorResponse;
import by.edu.currencyservice.exception.CurrencyDataAlreadyFetchedException;
import by.edu.currencyservice.exception.CurrencyDataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Map;

import static by.edu.currencyservice.util.Messages.INVALID_PARAMETER_TYPE_MESSAGE;
import static by.edu.currencyservice.util.Messages.REQUEST_PARAM_MISSING_MESSAGE;

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

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MultiErrorResponse handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException e) {
        var error = Map.of(e.getName(), e.getMessage());

        return MultiErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(INVALID_PARAMETER_TYPE_MESSAGE)
                .errors(error)
                .build();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MultiErrorResponse handleMissingRequestParameter(MissingServletRequestParameterException e) {
        var error = Map.of(e.getParameterName(), e.getMessage());

        return MultiErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(REQUEST_PARAM_MISSING_MESSAGE)
                .errors(error)
                .build();
    }
}
