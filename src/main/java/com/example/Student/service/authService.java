package com.example.Student.service;


import com.example.Student.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Student.Entity.authUser;
import java.util.List;

@Service
public class authService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepo repo;

    public List<authUser> gettAll(){
        return repo.findAll();
    }

    public authUser save(authUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

}
