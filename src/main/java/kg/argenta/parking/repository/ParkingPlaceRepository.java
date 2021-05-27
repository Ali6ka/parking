package kg.argenta.parking.repository;

import kg.argenta.parking.domain.ParkingPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ParkingPlaceRepository extends JpaRepository<ParkingPlace, Long> {
    Optional<ParkingPlace> findByNumber(String number);

    Collection<ParkingPlace> findAllByTakenIsFalse();

    Long countAllByTakenIsFalse();
}
