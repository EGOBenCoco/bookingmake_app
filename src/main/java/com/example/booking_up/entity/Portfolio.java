package com.example.booking_up.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    int experience;
    String description;
    @ManyToOne(fetch = FetchType.LAZY)
    Master master;

}
