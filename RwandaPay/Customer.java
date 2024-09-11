package com.rwandapay.model;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String phoneNumber;
    private String pin;
    private double balance = 10000000.0; // Initial balance

    // Getters and Setters
}
