package com.example.booking_up.entity;

import com.example.booking_up.enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PUBLIC)
@Inheritance
public abstract class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;
    String name;
    int date_of_birth;
    @Enumerated(EnumType.STRING)
    Gender gender;


}
