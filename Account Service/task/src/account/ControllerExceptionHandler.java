package account;


import dto.CustomErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<CustomErrorMessage> handleFlightNotFound(
            UserExistException e, WebRequest request) {

        CustomErrorMessage body = new CustomErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                e.getMessage(),
                request.getDescription(false),
                HttpStatus.BAD_REQUEST.getReasonPhrase());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
