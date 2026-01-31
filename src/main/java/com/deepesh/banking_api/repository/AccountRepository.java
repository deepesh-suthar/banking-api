package com.deepesh.banking_api.repository;

import com.deepesh.banking_api.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // You can add methods like findByUserId(Long userId) here if needed
}
