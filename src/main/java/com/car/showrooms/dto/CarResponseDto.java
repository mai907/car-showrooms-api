package com.car.showrooms.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarResponseDto {

    private Long id;
    private String vin;
    private String maker;
    private String model;
    private Integer modelYear;
    private Double amount;
    private String carShowroomName;
    private Integer contactNumber;
}
