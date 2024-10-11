package com.example.booking_up.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int rating;
    String title;
    @ManyToOne
    Client client;
    @ManyToOne
    Master master;
    String content;
}
// Создать два разных дто для этой сущности первая из которых должно иметь только клиента, а вторая мастера
