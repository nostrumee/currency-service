package by.edu.currencyservice.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(description = "Response with the result of fetching currency info from the NBRB API")
public record FetchingResultResponse(

        @Schema(name = "message", description = "Result of the fetching", example = "Currency data is successfully fetched")
        String message
) {
}
