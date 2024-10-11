package com.example.booking_up.entity;

import com.example.booking_up.enums.Enum_Service;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Service {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    int id;

    int price;

    @Enumerated(EnumType.STRING)
    Enum_Service service;

    @ManyToOne
    Master master;
}
