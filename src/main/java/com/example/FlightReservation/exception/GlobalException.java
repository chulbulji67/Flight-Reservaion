package com.example.FlightReservation.exception;

import com.example.FlightReservation.exception.flight.FlightNotFound;
import com.example.FlightReservation.exception.userException.PasswordAunticationFailed;
import com.example.FlightReservation.exception.userException.UserAlreadyExist;
import com.example.FlightReservation.exception.userException.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserAlreadyExist.class)
    public ResponseEntity<String> handleUserAlreadyExistException(UserAlreadyExist ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> handleUserAlreadyExistException(UserNotFound ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(PasswordAunticationFailed.class)
    public ResponseEntity<String> handleUserAlreadyExistException(PasswordAunticationFailed ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(FlightNotFound.class)
    public ResponseEntity<String> handleUserAlreadyExistException(FlightNotFound ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
