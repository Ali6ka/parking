package kg.argenta.parking.controller;

import kg.argenta.parking.dto.ParkingPlaceDto;
import kg.argenta.parking.dto.ParkingPlaceInfoDto;
import kg.argenta.parking.dto.UpdateParkingPlaceDto;
import kg.argenta.parking.endpoint.ParkingPlaceEndpoint;
import kg.argenta.parking.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/parking-places")
public class ParkingPlaceController {

    private final ParkingPlaceEndpoint endpoint;

    @PutMapping("/{number}")
    public ParkingPlaceDto update(
            @PathVariable String number,
            @Valid @RequestBody UpdateParkingPlaceDto updateDto
    ) throws NotFoundException {
        return endpoint.updateStatus(number, updateDto);
    }

    @GetMapping("/board-info")
    public ParkingPlaceInfoDto boardInfo() {
        return endpoint.getBoardInfo();
    }
}
