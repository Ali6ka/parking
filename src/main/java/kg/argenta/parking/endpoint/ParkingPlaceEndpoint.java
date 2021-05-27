package kg.argenta.parking.endpoint;

import kg.argenta.parking.dto.ParkingPlaceDto;
import kg.argenta.parking.dto.ParkingPlaceInfoDto;
import kg.argenta.parking.dto.UpdateParkingPlaceDto;
import kg.argenta.parking.exception.NotFoundException;

public interface ParkingPlaceEndpoint {

    ParkingPlaceInfoDto getBoardInfo();

    ParkingPlaceDto updateStatus(String number, UpdateParkingPlaceDto updateDto) throws NotFoundException;
}
