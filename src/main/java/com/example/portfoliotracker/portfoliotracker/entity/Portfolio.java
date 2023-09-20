package com.example.portfoliotracker.portfoliotracker.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Portfolio {
    public int getPortfolio_id() {
        return portfolio_id;
    }

    public void setPortfolio_id(int portfolio_id) {
        this.portfolio_id = portfolio_id;
    }

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int portfolio_id;

    public String getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(String investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    private String investmentAmount;
    @OneToMany(mappedBy = "portfolio")
    private List<Investment> investments = new ArrayList<>();
}
