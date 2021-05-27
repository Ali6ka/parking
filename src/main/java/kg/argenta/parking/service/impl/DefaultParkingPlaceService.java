package kg.argenta.parking.service.impl;

import kg.argenta.parking.domain.ParkingPlace;
import kg.argenta.parking.exception.NotFoundException;
import kg.argenta.parking.repository.ParkingPlaceRepository;
import kg.argenta.parking.service.ParkingPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class DefaultParkingPlaceService implements ParkingPlaceService {

    private final ParkingPlaceRepository repository;

    @Override
    @Transactional(readOnly = true)
    public ParkingPlace get(String number) throws NotFoundException {
        return repository
                .findByNumber(number)
                .orElseThrow(() -> new NotFoundException(ParkingPlace.class, number, "number"));
    }

    @Override
    @Transactional
    public ParkingPlace updateStatus(ParkingPlace parkingPlace, boolean taken) {
        parkingPlace.setTaken(taken);
        return repository.save(parkingPlace);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<ParkingPlace> findAllAvailable() {
        return repository.findAllByTakenIsFalse();
    }

    @Override
    @Transactional(readOnly = true)
    public Long countAvailable() {
        return repository.countAllByTakenIsFalse();
    }

    @Override
    @Transactional(readOnly = true)
    public Long countTotal() {
        return repository.count();
    }
}
