package com.car.showrooms.dao;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarSearchRequest {
    private String vin;
    private String maker;
    private String model;
    private Integer modelYear;
    private Double amount;
    private String carShowroomName;
    private Integer contactNumber;
}
