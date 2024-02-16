package com.example.FlightReservation.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Passenger extends AbstractEntity{


    private String firstName;
    private String lastName;
    private String middelName;
    private String  email;
    private String phone;
}
