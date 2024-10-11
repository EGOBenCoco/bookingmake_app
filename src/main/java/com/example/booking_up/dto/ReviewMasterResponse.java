package com.example.booking_up.dto;

import com.example.booking_up.entity.Master;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewMasterResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int rating;
    String title;
    @ManyToOne
    Master master;
    String content;
}