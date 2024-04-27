package com.library.security.payment;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="user_email")
    private String userEmail;

    @Column(name = "amount")
    private double amount;
}
