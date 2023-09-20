package com.example.portfoliotracker.portfoliotracker.repo;

import com.example.portfoliotracker.portfoliotracker.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
    public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    }
