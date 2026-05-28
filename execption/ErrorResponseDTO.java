package execption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponseDTO {
    private String message;
    private int statusCode;
    private Instant timestamp;
}
