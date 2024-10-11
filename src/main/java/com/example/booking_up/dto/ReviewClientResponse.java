package com.example.booking_up.dto;

import com.example.booking_up.entity.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewClientResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int rating;
    String title;
    @ManyToOne
    Client client;
    String content;
}
