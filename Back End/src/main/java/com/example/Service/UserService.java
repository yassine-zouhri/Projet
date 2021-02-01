package com.example.Service;

import org.springframework.security.core.userdetails.UserDetailsService;


import com.example.entities.Users;



public interface UserService extends UserDetailsService {

    Users findByEmail(String email);
}