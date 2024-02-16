package com.example.FlightReservation.repos;

import com.example.FlightReservation.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE f.departureCity = :departureCity AND f.arrivalCity = :arrivalCity AND f.dateOfDeparture = :dateOfDeparture")
    List<Flight> findFromTo(String departureCity, String arrivalCity, Date dateOfDeparture);
}
