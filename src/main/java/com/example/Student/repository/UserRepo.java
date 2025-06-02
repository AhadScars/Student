package com.example.Student.repository;

import com.example.Student.Entity.authUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<authUser, Integer> {
    authUser findByUsername (String username);
}
