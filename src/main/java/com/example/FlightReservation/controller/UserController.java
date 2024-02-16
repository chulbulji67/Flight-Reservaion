package com.example.FlightReservation.controller;

import com.example.FlightReservation.dto.Login;
import com.example.FlightReservation.entity.User;
import com.example.FlightReservation.repos.UserRepo;
import com.example.FlightReservation.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @PostMapping("/registerUser")
    public ResponseEntity<?> register(@RequestBody User user){
        return ResponseEntity.status(201).body(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login, HttpServletRequest request, HttpServletResponse response){
    return ResponseEntity.ok().body(userService.login(login, request, response));
    }

    //Get User by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUsersById(id);
    }

}
