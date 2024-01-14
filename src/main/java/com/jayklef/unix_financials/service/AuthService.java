package com.jayklef.unix_financials.service;

import com.jayklef.unix_financials.config.JwtAuthenticationProvider;
import com.jayklef.unix_financials.dto.AdminDto;
import com.jayklef.unix_financials.dto.LoginDto;
import com.jayklef.unix_financials.dto.ResponseDto;
import com.jayklef.unix_financials.entity.UserCred;
import com.jayklef.unix_financials.mapper.CustomMapper;
import com.jayklef.unix_financials.repository.UserCredRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final AuthenticationManager authenticationManager;
    private final UserCredRepository userCredRepository;
    private final CustomMapper customMapper;

    public ResponseDto login(LoginDto loginDto){

        UserCred userCred = userCredRepository.findUserByEmail(loginDto.getEmail())
                .orElseThrow(()->new UsernameNotFoundException("user not found"));

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );

        String token = jwtAuthenticationProvider.generateToken(authentication);

        AdminDto adminDetails = customMapper.mapToDto(userCred);

        return ResponseDto.builder()
                .adminDto(adminDetails)
                .token(token)
                .build();
    }
}
