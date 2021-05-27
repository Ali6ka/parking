package kg.argenta.parking.service;

import kg.argenta.parking.domain.ParkingPlace;
import kg.argenta.parking.exception.NotFoundException;

import java.util.Collection;

public interface ParkingPlaceService {

    ParkingPlace get(String number) throws NotFoundException;
    ParkingPlace updateStatus(ParkingPlace parkingPlace, boolean taken);

    Collection<ParkingPlace> findAllAvailable();

    Long countAvailable();

    Long countTotal();
}
