package by.edu.currencyservice.exception;

import static by.edu.currencyservice.util.Messages.CURRENCY_DATA_NOT_FOUND_MESSAGE;

public class CurrencyDataNotFoundException extends RuntimeException {

    public CurrencyDataNotFoundException(String code, String date) {
        super(String.format(CURRENCY_DATA_NOT_FOUND_MESSAGE, code, date));
    }
}
