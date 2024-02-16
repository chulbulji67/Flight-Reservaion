package com.example.FlightReservation.service.impl;

import com.example.FlightReservation.dto.Login;
import com.example.FlightReservation.entity.User;
import com.example.FlightReservation.exception.userException.PasswordAunticationFailed;
import com.example.FlightReservation.exception.userException.UserAlreadyExist;
import com.example.FlightReservation.exception.userException.UserNotFound;
import com.example.FlightReservation.repos.UserRepo;
import com.example.FlightReservation.service.SecurityService;
import com.example.FlightReservation.service.Userservice;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements Userservice {

    @Autowired
    UserRepo userRepo;

    @Autowired
    SecurityService securityService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public User register(User user) {
        //if user already exist then throw exception User already exist
        User existUser = userRepo.findByEmail(user.getEmail());
        if(existUser != null) throw new UserAlreadyExist("User already exist with this email");

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //Save the user and return
        return userRepo.save(user);
    }

    @Override
    public User login(Login login, HttpServletRequest request, HttpServletResponse response) {
        //Check if User exist with the given email if not exist throw exception UserNotFoundException
        User existUser = userRepo.findByEmail(login.getEmail());
        if(existUser == null) throw  new UserNotFound("User not found with email "+login.getEmail());

        boolean login1 = securityService.login(login.getEmail(), login.getPassword(), request, response);
        //chenck if password is correct
//        if(!existUser.getPassword().equals(login.getPassword())){
//            throw new PasswordAunticationFailed("Password is not correct try again");
//        }

        return existUser;
    }

    @Override
    public User getUsersById(long id) {
        //Check if User exist with the given email if not exist throw exception UserNotFoundException
        User existUser = userRepo.findById(id).orElse(null);
        if(existUser == null) throw  new UserNotFound("User not found with given id");

        //Return existing user
        return existUser;
    }
}
