package kg.argenta.parking.mapper;

import kg.argenta.parking.domain.ParkingPlace;
import kg.argenta.parking.dto.ParkingPlaceDto;

public interface ParkingPlaceMapper {

    ParkingPlaceDto toParkingPlaceDto(ParkingPlace parkingPlace);
}
