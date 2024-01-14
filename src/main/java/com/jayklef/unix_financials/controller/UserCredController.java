package com.jayklef.unix_financials.controller;

import com.jayklef.unix_financials.dto.LoginDto;
import com.jayklef.unix_financials.dto.ResponseDto;
import com.jayklef.unix_financials.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
public class UserCredController {

    private final AuthService authService;

    @PostMapping("login")
    public ResponseDto login(@RequestBody LoginDto loginDto){
        return authService.login(loginDto);
    }
}
