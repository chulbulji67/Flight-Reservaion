package com.example.FlightReservation.service;

import com.example.FlightReservation.entity.Flight;

import java.util.Date;
import java.util.List;

public interface FlightService {
    public Flight addFlight(Flight flight);
    public Flight getFlightById(long id);

    public List<Flight> getAllFlights();

    public List<Flight> findAllFligh(String from, String to, Date dateOfDeparture);
}
