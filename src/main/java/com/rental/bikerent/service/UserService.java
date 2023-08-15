package com.rental.bikerent.service;


import com.rental.bikerent.model.User;
import com.rental.bikerent.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto) throws Exception;

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}