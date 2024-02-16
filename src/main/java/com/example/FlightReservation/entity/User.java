package com.example.FlightReservation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity{


    private String firstName;
    private String lastName;

    private String email;

    private String password;

    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    private Set<Role> roles;

}
