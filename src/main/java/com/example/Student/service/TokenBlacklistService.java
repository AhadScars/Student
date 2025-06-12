package com.example.Student.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenBlacklistService {

    private final Map<String, Date> blacklist = new HashMap<>();

    public void blacklistToken(String token, Date expiryDate) {
        blacklist.put(token, expiryDate);
    }

    public boolean isTokenBlacklisted(String token) {
        Date expiry = blacklist.get(token);
        if (expiry == null) return false;

        if (expiry.before(new Date())) {
            blacklist.remove(token);
            return false;
        }

        return true;
    }
}