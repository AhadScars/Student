package com.example.Student.security;

import com.example.Student.Entity.authUser;
import com.example.Student.Entity.userPrinciple;
import com.example.Student.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CostumerService implements UserDetailsService {

    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        authUser auth =repo.findByUsername(username);

        if (auth==null){
            System.out.println("not found");

            throw new UsernameNotFoundException("not found");
        }

        return new userPrinciple(auth);
    }
}
