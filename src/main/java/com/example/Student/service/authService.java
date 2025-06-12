package com.example.Student.service;


import com.example.Student.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Student.Entity.authUser;
import java.util.List;

@Service
public class authService {
    @Autowired
    private JWTservice jwTservice;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
    @Autowired
    UserRepo repo;
    public List<authUser> gettAll(){
        return repo.findAll();
    }
    public authUser save(authUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public String verify(authUser user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if (authentication.isAuthenticated()){
            return jwTservice.generateToken(user.getUsername());

        }
        return "failure";
    }
}
