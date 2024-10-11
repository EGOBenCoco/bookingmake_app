package com.example.booking_up.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MasterResponse {
    int id;
    String name;
    String location;
/*    @Enumerated(EnumType.STRING)
    Service service;*/
}
