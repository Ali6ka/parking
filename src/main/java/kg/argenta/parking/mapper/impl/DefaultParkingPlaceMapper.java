package kg.argenta.parking.mapper.impl;

import kg.argenta.parking.domain.ParkingPlace;
import kg.argenta.parking.dto.ParkingPlaceDto;
import kg.argenta.parking.mapper.ParkingPlaceMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultParkingPlaceMapper implements ParkingPlaceMapper {

    @Override
    public ParkingPlaceDto toParkingPlaceDto(ParkingPlace parkingPlace) {
        return ParkingPlaceDto.builder()
                .number(parkingPlace.getNumber())
                .taken(parkingPlace.getTaken())
                .build();
    }
}
