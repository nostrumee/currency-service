package by.edu.currencyservice.exception;

import static by.edu.currencyservice.util.Messages.CURRENCY_DATA_ALREADY_FETCHED_MESSAGE;

public class CurrencyDataIsAlreadyFetchedException extends RuntimeException {

    public CurrencyDataIsAlreadyFetchedException(String date) {
        super(String.format(CURRENCY_DATA_ALREADY_FETCHED_MESSAGE, date));
    }

}
