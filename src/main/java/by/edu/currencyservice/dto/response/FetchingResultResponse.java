package by.edu.currencyservice.dto.response;

import lombok.Builder;

@Builder
public record FetchingResultResponse(
        String message
) {
}
