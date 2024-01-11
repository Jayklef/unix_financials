package com.jayklef.unix_financials.mapper;

import com.jayklef.unix_financials.dto.AdminDto;
import com.jayklef.unix_financials.entity.UserCred;

public class CustomMapper {

    public AdminDto mapToDto(UserCred userCred){
        return AdminDto.builder().build();
    }
}
