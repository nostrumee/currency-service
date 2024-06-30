package by.edu.currencyservice.exception;

import static by.edu.currencyservice.util.Messages.CURRENCY_DATA_ALREADY_FETCHED_MESSAGE;

public class CurrencyDataAlreadyFetchedException extends RuntimeException {

    public CurrencyDataAlreadyFetchedException(String date) {
        super(String.format(CURRENCY_DATA_ALREADY_FETCHED_MESSAGE, date));
    }

}
