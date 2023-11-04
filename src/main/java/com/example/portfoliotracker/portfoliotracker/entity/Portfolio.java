package com.example.portfoliotracker.portfoliotracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "portfolio_details")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "investment_id" , unique = true)
    private int investment_id;
    public int getInvestment_id() {
        return investment_id;
    }

    public void setInvestment_id(int investment_id) {
        this.investment_id = investment_id;
    }
    @Column(name = "investment_amount")
    private int investmentAmount;
    public int getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(int investmentAmount) {
        this.investmentAmount = investmentAmount;
    }
    @Column(name = "investment_type")
    private String investment_type;
    public String getInvestment_type() {
        return investment_type;
    }

    public void setInvestment_type(String investment_type) {
        this.investment_type = investment_type;
    }

}
