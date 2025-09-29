package com.car.showrooms.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarRequestDto {

    private String vin;
    private String maker;
    private String model;
    private Integer modelYear;
    private Double price;
}
