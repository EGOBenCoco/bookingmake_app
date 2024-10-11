package com.example.booking_up.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Master extends Consumer {


    String location;

    @OneToMany(cascade = {CascadeType.REMOVE,CascadeType.PERSIST, CascadeType.MERGE},mappedBy = "master",fetch = FetchType.EAGER)
    List<Service> listServices;

    @OneToMany(cascade = {CascadeType.REMOVE,CascadeType.PERSIST, CascadeType.MERGE},mappedBy = "master",fetch = FetchType.EAGER)
    List<Portfolio> portfolio;
}
