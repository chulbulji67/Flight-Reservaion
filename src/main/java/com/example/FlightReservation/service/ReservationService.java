package com.example.FlightReservation.service;

import com.example.FlightReservation.dto.ReservationRequest;
import com.example.FlightReservation.entity.Reservation;

public interface ReservationService {
    public Reservation bookFlight(ReservationRequest reservationRequest);
}
