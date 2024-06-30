package by.edu.currencyservice.mapper;

import by.edu.currencyservice.dto.response.CurrencyApiResponse;
import by.edu.currencyservice.dto.response.CurrencyResponse;
import by.edu.currencyservice.persistence.entity.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CurrencyMapper {

    Currency fromApiResponseToEntity(CurrencyApiResponse apiResponse);

    CurrencyResponse fromEntityToResponse(Currency currency);
}
