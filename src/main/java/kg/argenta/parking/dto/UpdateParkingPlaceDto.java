package kg.argenta.parking.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class UpdateParkingPlaceDto {
    @NotNull
    private Boolean taken;
}
