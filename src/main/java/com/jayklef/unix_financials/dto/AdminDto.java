package com.jayklef.unix_financials.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String team;
    private String role;

}
