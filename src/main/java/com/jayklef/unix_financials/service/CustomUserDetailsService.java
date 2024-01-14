package com.jayklef.unix_financials.service;

import com.jayklef.unix_financials.repository.UserCredRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserCredRepository userCredRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userCredRepository.findUserByEmail(email).orElseThrow(
                ()-> new UsernameNotFoundException("user not found")
        );
    }
}
