package com.example.Student.controller;


import com.example.Student.Entity.authUser;
import com.example.Student.service.authService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class AuthController {

    @Autowired
    authService service;

    @GetMapping("/all")
    public List<authUser> gettAll(){
        return service.gettAll();
    }

    @PostMapping("/add")
    public authUser save(@RequestBody authUser user){
    return service.save(user);
    }
}
