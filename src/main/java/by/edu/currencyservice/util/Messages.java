package by.edu.currencyservice.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Messages {
    public static final String CURRENCY_DATA_ALREADY_FETCHED_MESSAGE
            = "Currency data for the date %s is already fetched";

    public static final String CURRENCY_DATA_SUCCESSFULLY_FETCHED_MESSAGE
            = "Currency data is successfully fetched";

    public static final String CURRENCY_DATA_NOT_FOUND_MESSAGE
            = "Currency data for the code %s and the date %s was not found";

    public static final String INVALID_PARAMETER_TYPE_MESSAGE = "Invalid parameter type";

    public static final String REQUEST_PARAM_MISSING_MESSAGE = "Request param missing";
}
