package com.example.portfoliotracker.portfoliotracker.repo;

import com.example.portfoliotracker.portfoliotracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
