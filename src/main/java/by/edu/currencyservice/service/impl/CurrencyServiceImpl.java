package by.edu.currencyservice.service.impl;

import by.edu.currencyservice.client.NbrbCurrencyClient;
import by.edu.currencyservice.dto.response.CurrencyApiResponse;
import by.edu.currencyservice.dto.response.CurrencyResponse;
import by.edu.currencyservice.dto.response.FetchingResultResponse;
import by.edu.currencyservice.exception.CurrencyDataIsAlreadyFetchedException;
import by.edu.currencyservice.exception.CurrencyDataNotFoundException;
import by.edu.currencyservice.mapper.CurrencyMapper;
import by.edu.currencyservice.persistence.entity.Currency;
import by.edu.currencyservice.persistence.repository.CurrencyRepository;
import by.edu.currencyservice.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static by.edu.currencyservice.util.Messages.CURRENCY_DATA_SUCCESSFULLY_FETCHED_MESSAGE;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyServiceImpl implements CurrencyService {

    private final NbrbCurrencyClient currencyClient;
    private final CurrencyMapper currencyMapper;
    private final CurrencyRepository currencyRepository;

    @Override
    public FetchingResultResponse fetchCurrenciesByDate(LocalDate date) {
        log.info("Fetching currency data for the date: {}", date);

        checkIfDataIsAlreadyFetched(date);

        List<CurrencyApiResponse> currenciesFromApi = currencyClient.getCurrencies(date);
        List<Currency> currencies = currenciesFromApi.stream()
                .map(currencyMapper::fromApiResponseToEntity)
                .toList();

        currencyRepository.saveAll(currencies);

        return FetchingResultResponse.builder()
                .message(CURRENCY_DATA_SUCCESSFULLY_FETCHED_MESSAGE)
                .build();
    }

    @Override
    public CurrencyResponse getCurrencyRateByCodeAndDate(String code, LocalDate date) {
        log.info("Retrieving currency data for the code {} and the date {}", code, date);

        Currency currency = currencyRepository.findByCodeAndDate(code, date)
                .orElseThrow(() -> {
                    log.error("Currency data for the code {} and the date {} was not found", code, date);

                    String formattedDate = formatLocalDate(date);
                    return new CurrencyDataNotFoundException(code, formattedDate);
                });

        return currencyMapper.fromEntityToResponse(currency);
    }

    private void checkIfDataIsAlreadyFetched(LocalDate date) {
        if (currencyRepository.existsByDate(date)) {
            log.info("Currency data for the date {} is already fetched", date);

            String formattedDate = formatLocalDate(date);
            throw new CurrencyDataIsAlreadyFetchedException(formattedDate);
        }
    }

    private String formatLocalDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
}
