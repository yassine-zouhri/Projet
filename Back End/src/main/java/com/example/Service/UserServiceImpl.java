package com.example.Service;


import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entities.Roles;
import com.example.entities.Users;
import com.example.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Users findByEmail(String email){
    	System.out.println("myyyyyyyyyyyemaillllllll="+userRepository.findByEmail(email));
        return userRepository.findByEmail(email);
    }


    @SuppressWarnings("unused")
	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email);
        System.out.println("ggggggggggggggggggggggggggggggggggggggg="+user.toString());
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa="+user.getEmail()+"rrrr"+user.getPassword()+"rrrrr"+mapRolesToAuthorities(user.getRoles())+"hhhhh   "+passwordEncoder.encode(user.getPassword()));
        
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
        		passwordEncoder.encode(user.getPassword()),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Roles> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}

