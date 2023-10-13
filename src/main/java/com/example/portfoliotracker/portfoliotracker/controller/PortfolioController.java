package com.example.portfoliotracker.portfoliotracker.controller;
import com.example.portfoliotracker.portfoliotracker.entity.Portfolio;
import com.example.portfoliotracker.portfoliotracker.repo.PortfolioRepository;
import com.example.portfoliotracker.portfoliotracker.generateUniqueNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @GetMapping("/list")
    public List<Portfolio> listPortfolios() {
        return portfolioRepository.findAll();
    }
    @PostMapping("/create")
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
        generateUniqueNumber gUN = new generateUniqueNumber(portfolioRepository);
        int folioNumber;
        do {
            folioNumber = gUN.generateUniqueNumber();
            // Set the folio number and save the portfolio
            portfolio.setPortfolio_id(folioNumber);
        }
        while (gUN.folioNumberExists(folioNumber));
        return portfolioRepository.save(portfolio);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePortfolio(@PathVariable("id") int id) {
        portfolioRepository.deleteById(id);
    }

}
