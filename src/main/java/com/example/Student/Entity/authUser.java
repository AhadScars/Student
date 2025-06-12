package com.example.Student.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @Entity
    @NoArgsConstructor@AllArgsConstructor
    public class authUser {

        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Integer id;
        private String username;
        private String password;

    }
