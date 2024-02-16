package com.example.FlightReservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FromToDateInfo {
    private String departureCity;
    private String arrivalCity;
    private Date dateOfDeparture;
}
