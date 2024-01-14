package com.jayklef.unix_financials.repository;

import com.jayklef.unix_financials.entity.UserCred;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredRepository extends JpaRepository<UserCred, Long> {

    Optional<UserCred> findUserByEmail(String email);
}
