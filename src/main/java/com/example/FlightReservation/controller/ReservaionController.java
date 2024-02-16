package com.example.FlightReservation.controller;

import com.example.FlightReservation.dto.ReservationRequest;
import com.example.FlightReservation.entity.Reservation;
import com.example.FlightReservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservaionController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/completeResrvaion")
    public Reservation completeReservation(@RequestBody ReservationRequest reservationRequest){

        System.out.println(reservationRequest.getFlightId()+" "+reservationRequest.getCardNumber());
        Reservation reservation = reservationService.bookFlight(reservationRequest);

        return reservation;

    }
}
