package kg.argenta.parking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingPlaceInfoDto {
    Collection<ParkingPlaceDto> availablePlaces;
    Long countAvailable;
    Long countTotal;
}
