package com.example.FlightReservation.service.impl;

import com.example.FlightReservation.entity.Flight;
import com.example.FlightReservation.exception.flight.FlightNotFound;
import com.example.FlightReservation.repos.FlightRepo;
import com.example.FlightReservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepo flightRepo;
    @Override
    public Flight addFlight(Flight flight) {
        return flightRepo.save(flight);
    }

    @Override
    public Flight getFlightById(long id) {
        //if Flight does not exists with given id thorw Flight not found exception
        Flight existingFlight = flightRepo.findById(id).orElse(null);
        if(existingFlight == null){
            throw new FlightNotFound("Flight not found");
        }

        return existingFlight;
    }

    @Override
    public List<Flight> getAllFlights() {
        List<Flight> flights = flightRepo.findAll();
        if(flights.size() == 0){
            throw new FlightNotFound("Currently there is no Flight");
        }
        return flights;
    }

    @Override
    public List<Flight> findAllFligh(String from, String to, Date dateOfDeparture) {
        List<Flight> flights = flightRepo.findFromTo(from, to,  dateOfDeparture);
        return flights;
    }
}
