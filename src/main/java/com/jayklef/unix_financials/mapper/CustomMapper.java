package com.jayklef.unix_financials.mapper;

import com.jayklef.unix_financials.dto.AdminDto;
import com.jayklef.unix_financials.entity.UserCred;
import org.springframework.stereotype.Component;

@Component
public class CustomMapper {

    public AdminDto mapToDto(UserCred userCred){

        return AdminDto.builder()
                .id(userCred.getId())
                .firstname(userCred.getFirstName())
                .lastname(userCred.getLastName())
                .email(userCred.getEmail())
                .team(userCred.getTeam().toString())
                .role(userCred.getRole().toString())
                .build();
    }
}
