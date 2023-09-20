package com.example.portfoliotracker.portfoliotracker.entity;

import jakarta.persistence.*;

@Entity
public class Investment {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double amount;
    @ManyToOne
    @JoinColumn(name = "portfolio_id")  // This is the column name in the Investment table
    private Portfolio portfolio;
}
