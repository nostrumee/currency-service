package by.edu.currencyservice.dto.response.error;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(description = "Response with the info about occurred error/exception")
public record ErrorResponse(

        @Schema(name = "status", description = "HTTP status of the response", example = "404")
        int status,

        @Schema(name = "message", description = "Message of the error", example = "Currency not found")
        String message
) {
}
