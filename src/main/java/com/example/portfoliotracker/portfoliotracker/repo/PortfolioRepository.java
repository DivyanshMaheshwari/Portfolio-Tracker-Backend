package com.example.portfoliotracker.portfoliotracker.repo;
import com.example.portfoliotracker.portfoliotracker.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {
    }
