package com.example.Student.controller;


import com.example.Student.Entity.authUser;
import com.example.Student.service.JWTservice;
import com.example.Student.service.TokenBlacklistService;
import com.example.Student.service.authService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/register")
public class AuthController {

    @Autowired
    authService service;

    @Autowired
    TokenBlacklistService blacklistToken;

    @Autowired
    JWTservice jwTservice;

    @GetMapping("/all")
    public List<authUser> gettAll(){
        return service.gettAll();
    }

    @PostMapping("/register")
    public authUser register(@RequestBody authUser user){
    return service.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody authUser user){
        return service.verify(user);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            Date expiry = jwTservice.extractExpiration(token);
            blacklistToken.blacklistToken(token, expiry);
            return ResponseEntity.ok("Logout successful. Token is nw blacklist.");
        } else {
            return ResponseEntity.badRequest().body("Missing or invalid Authorization header");
        }
    }

}
