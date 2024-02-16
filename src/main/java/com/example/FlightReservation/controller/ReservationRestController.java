package com.example.FlightReservation.controller;

import com.example.FlightReservation.dto.ReservaionUpdateRequest;
import com.example.FlightReservation.dto.ReservationRequest;
import com.example.FlightReservation.entity.Reservation;
import com.example.FlightReservation.repos.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ReservationRestController {

    @Autowired
    ReservationRepo reservationRepo;

    @GetMapping("/reservations/{id}")
    public Reservation findResevation(@PathVariable long id){
        return reservationRepo.findById(id).get();
    }

    @PutMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservaionUpdateRequest reservaionUpdateRequest){
        Reservation reservation = reservationRepo.findById(reservaionUpdateRequest.getId()).get();
        reservation.setNumberOFBags(reservaionUpdateRequest.getNumberOfBags());
        reservation.setCheckedIn(reservaionUpdateRequest.getCheckedIn());

        return reservationRepo.save(reservation);
    }
}
