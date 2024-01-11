package com.jayklef.unix_financials.config;

import com.jayklef.unix_financials.dto.AdminDto;
import com.jayklef.unix_financials.entity.Role;
import com.jayklef.unix_financials.entity.Team;
import com.jayklef.unix_financials.entity.UserCred;
import com.jayklef.unix_financials.repository.UserCredRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class Runner implements CommandLineRunner {

    private UserCredRepository userCredRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        UserCred admin = UserCred.builder()
                .firstName("jerry")
                .lastName("Amadi")
                .email("jerry@gmail.com")
                .password(passwordEncoder.encode("1234"))
                .role(Role.ROLE_SUPER_ADMIN)
                .team(Team.ENGINEER)
                .build();
        log.info("saving super admin with name {} to DB ", admin);
        userCredRepository.save(admin);
    }
}
