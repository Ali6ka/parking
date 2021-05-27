package kg.argenta.parking.exception;

import lombok.Getter;

@Getter
public abstract class ParkingException extends Exception {
    private String message;

    public ParkingException(String message) {
        this.message = message;
    }
}

