package com.example.FlightReservation.service;

import com.example.FlightReservation.dto.Login;
import com.example.FlightReservation.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Userservice {

    User register(User user);

    User login(Login login, HttpServletRequest request, HttpServletResponse response);

    User getUsersById(long id);

}
