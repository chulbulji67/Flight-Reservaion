package com.example.FlightReservation.service.impl;

import com.example.FlightReservation.dto.ReservationRequest;
import com.example.FlightReservation.entity.Flight;
import com.example.FlightReservation.entity.Passenger;
import com.example.FlightReservation.entity.Reservation;
import com.example.FlightReservation.exception.flight.FlightNotFound;
import com.example.FlightReservation.repos.FlightRepo;
import com.example.FlightReservation.repos.PassengerRepo;
import com.example.FlightReservation.repos.ReservationRepo;
import com.example.FlightReservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    FlightRepo flightRepo;

    @Autowired
    PassengerRepo passengerRepo;

    @Autowired
    ReservationRepo reservationRepo;

    @Override
    public Reservation bookFlight(ReservationRequest reservationRequest) {
        //Make payment

        long flightId = reservationRequest.getFlightId();
        System.out.println("flightId"+flightId);
        Flight flight = flightRepo.findById(flightId).orElse(null);

        if(flight == null) throw new FlightNotFound("Flight Not Found with this Id "+flightId);

        Passenger passenger = new Passenger();
        passenger.setFirstName(reservationRequest.getPassangerFirstName());
        passenger.setMiddelName(reservationRequest.getPassangerMiddleName());
        passenger.setLastName(reservationRequest.getPassangerLastName());
        passenger.setPhone(reservationRequest.getPassengerPhone());
        passenger.setEmail(reservationRequest.getPassangerEmail());

        Passenger savedPassanger = passengerRepo.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassanger);
        reservation.setCheckedIn(false);

        Reservation savedResvervation = reservationRepo.save(reservation);
        return savedResvervation;

    }
}
