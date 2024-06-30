package by.edu.currencyservice.dto.response.error;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.Map;

@Builder
@Schema(description = "Response with the info about occurred errors/exceptions")
public record MultiErrorResponse(

        @Schema(name = "status", description = "HTTP status of the response", example = "400")
        int status,

        @Schema(name = "message", description = "Message of the error", example = "Method argument not valid")
        String message,

        @Schema(name = "errors", description = "Information about occurred errors")
        Map<String, String> errors
) {
}
