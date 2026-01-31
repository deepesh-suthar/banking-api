package com.deepesh.banking_api.repository;

import com.deepesh.banking_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entity Type, ID Type>
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom method to find user by email (Spring implements this automatically!)
    User findByEmail(String email);
}
