package com.example.FlightReservation.exception.userException;

public class PasswordAunticationFailed extends RuntimeException {
    public PasswordAunticationFailed(String s) {
        super((s));
    }
}
