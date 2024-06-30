package by.edu.currencyservice.dto.response;

import lombok.Builder;

@Builder
public record ErrorResponse(
        int status,
        String message
) {
}
