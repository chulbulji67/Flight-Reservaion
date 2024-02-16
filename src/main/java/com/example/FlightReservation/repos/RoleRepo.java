package com.example.FlightReservation.repos;

import com.example.FlightReservation.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
