package kg.argenta.parking.controller.exception;

import kg.argenta.parking.dto.error.NotFoundErrorResponseDto;
import kg.argenta.parking.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
class GlobalControllerExceptionHandler {

    private static final String RESOURCE_NOT_FOUND = "Resource not found";

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    NotFoundErrorResponseDto handleNotFoundErrorResponseDto(NotFoundException exception) {
        String message = getMessage(exception, RESOURCE_NOT_FOUND);

        return new NotFoundErrorResponseDto(message);
    }

    private String getMessage(Exception exception, String defaultMessage) {
        String message = defaultMessage;

        if (Objects.nonNull(exception.getLocalizedMessage())) {
            message = exception.getLocalizedMessage();
        }
        if (Objects.nonNull(exception.getMessage())) {
            message = exception.getMessage();
        }

        return message;
    }
}
