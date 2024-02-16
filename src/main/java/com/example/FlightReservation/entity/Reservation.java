package com.example.FlightReservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation extends AbstractEntity {



    private Boolean checkedIn;

    private int numberOFBags;

    @OneToOne
    private Passenger passenger;

    @OneToOne
    private Flight flight;
}
