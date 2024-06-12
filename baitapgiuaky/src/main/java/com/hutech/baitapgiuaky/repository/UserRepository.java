package com.hutech.baitapgiuaky.repository;

import com.hutech.baitapgiuaky.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}

