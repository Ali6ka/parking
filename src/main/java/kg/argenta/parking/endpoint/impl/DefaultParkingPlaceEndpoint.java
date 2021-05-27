package kg.argenta.parking.endpoint.impl;

import kg.argenta.parking.domain.ParkingPlace;
import kg.argenta.parking.dto.ParkingPlaceDto;
import kg.argenta.parking.dto.ParkingPlaceInfoDto;
import kg.argenta.parking.dto.UpdateParkingPlaceDto;
import kg.argenta.parking.endpoint.ParkingPlaceEndpoint;
import kg.argenta.parking.exception.NotFoundException;
import kg.argenta.parking.mapper.ParkingPlaceMapper;
import kg.argenta.parking.service.ParkingPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultParkingPlaceEndpoint implements ParkingPlaceEndpoint {

    private final ParkingPlaceService service;
    private final ParkingPlaceMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public ParkingPlaceInfoDto getBoardInfo() {
        Collection<ParkingPlace> availablePlaces = service.findAllAvailable();

        List<ParkingPlaceDto> resultPlaces = new ArrayList<>();
        for (ParkingPlace parkingPlace : availablePlaces) {
            ParkingPlaceDto parkingPlaceDto = mapper.toParkingPlaceDto(parkingPlace);
            resultPlaces.add(parkingPlaceDto);
        }

        Long countAvailable = service.countAvailable();
        Long countTotal = service.countTotal();

        return ParkingPlaceInfoDto.builder()
                .availablePlaces(resultPlaces)
                .countAvailable(countAvailable)
                .countTotal(countTotal)
                .build();
    }

    @Override
    @Transactional
    public ParkingPlaceDto updateStatus(
            String number,
            UpdateParkingPlaceDto updateDto
    ) throws NotFoundException {
        ParkingPlace parkingPlace = service.get(number);

        service.updateStatus(parkingPlace, updateDto.getTaken());

        return mapper.toParkingPlaceDto(parkingPlace);
    }
}
