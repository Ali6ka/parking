package kg.argenta.parking;

import kg.argenta.parking.domain.ParkingPlace;
import kg.argenta.parking.dto.ParkingPlaceInfoDto;
import kg.argenta.parking.repository.ParkingPlaceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ParkingApplicationTests {

    @MockBean
    private ParkingPlaceRepository parkingPlaceRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void canRetrieveAvailablePlacesInfo() {

        Collection<ParkingPlace> availablePlaces = List.of(
                new ParkingPlace("A1", false),
                new ParkingPlace("A2", false)
        );

        Collection<ParkingPlace> takenPlaces = List.of(
                new ParkingPlace("A3", true),
                new ParkingPlace("A4", true)
        );

        Mockito.when(parkingPlaceRepository.findAllByTakenIsFalse())
                .thenReturn(availablePlaces);

        Mockito.when(parkingPlaceRepository.countAllByTakenIsFalse())
                .thenReturn((long) availablePlaces.size());

        Mockito.when(parkingPlaceRepository.count())
                .thenReturn((long) (availablePlaces.size() + takenPlaces.size()));

        ResponseEntity<ParkingPlaceInfoDto> response =
                restTemplate.getForEntity("/api/v1/parking-places/board-info", ParkingPlaceInfoDto.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getCountAvailable()).isEqualTo(2L);
        assertThat(response.getBody().getCountTotal()).isEqualTo(4L);
    }

}
