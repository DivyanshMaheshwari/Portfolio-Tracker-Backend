package com.example.portfoliotracker.portfoliotracker;

import com.example.portfoliotracker.portfoliotracker.repo.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class generateUniqueNumber {
    private final PortfolioRepository portfolioRepository;

    @Autowired
    public generateUniqueNumber(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }
    public int generateUniqueNumber() {
        Random random = new Random();
        int folioNumber = 100000 + random.nextInt(900000); // Generate a six-digit number
        return folioNumber;
    }
    public boolean folioNumberExists(int folioNumber) {
        // Check if the folio number already exists in the database
        return portfolioRepository.findById(folioNumber).isPresent();
    }
}
