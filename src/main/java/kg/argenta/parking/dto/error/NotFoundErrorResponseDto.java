package kg.argenta.parking.dto.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotFoundErrorResponseDto {
    private String message;
}
