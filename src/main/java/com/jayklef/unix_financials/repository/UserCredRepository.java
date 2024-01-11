package com.jayklef.unix_financials.repository;

import com.jayklef.unix_financials.entity.UserCred;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredRepository extends JpaRepository<UserCred, Long> {
}
