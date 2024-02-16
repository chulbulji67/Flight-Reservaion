package com.example.FlightReservation.controller;

import com.example.FlightReservation.dto.FromToDateInfo;
import com.example.FlightReservation.entity.Flight;
import com.example.FlightReservation.repos.FlightRepo;
import com.example.FlightReservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    //Add flight
    @PostMapping("/add-flight")
    public ResponseEntity<?> addFlight(@RequestBody Flight flight){
        return ResponseEntity.status(201).body(flightService.addFlight(flight));
    }

    //Get Flight By id
    @GetMapping("/{id}")
    public ResponseEntity<?> getFlightById(@PathVariable int id){
        return ResponseEntity.ok().body(flightService.getFlightById(id));
    }

    //Get All the Flights
    @GetMapping()
    public ResponseEntity<?> getAllFlights(){
        return ResponseEntity.ok().body(flightService.getAllFlights());
    }

    //Get all the flights which travel from and to and at specific time
    @GetMapping("/from-to")
    public ResponseEntity<?> findAllFlightFromTo(@RequestBody FromToDateInfo fromTo){
    return ResponseEntity.ok().body(flightService.findAllFligh(fromTo.getDepartureCity(), fromTo.getArrivalCity(),fromTo.getDateOfDeparture()));
    }
}
