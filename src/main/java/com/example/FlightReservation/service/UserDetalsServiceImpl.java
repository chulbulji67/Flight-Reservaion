package com.example.FlightReservation.service;

import com.example.FlightReservation.entity.Role;
import com.example.FlightReservation.entity.User;
import com.example.FlightReservation.exception.userException.UserNotFound;
import com.example.FlightReservation.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class UserDetalsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if(user == null){
            throw new UserNotFound("User with this email does not exist");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),grandedAuthrity(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> grandedAuthrity(Set<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role:roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
}
