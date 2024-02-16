package com.example.FlightReservation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {

    private long flightId;
    private String passangerFirstName;
    private String passangerMiddleName;
    private String passangerLastName;

    private String passangerEmail;

    private String passengerPhone;

    private String nameOntheCard;
    private String cardNumber;
    private String expirationDate;
    private String securityCode;


}
