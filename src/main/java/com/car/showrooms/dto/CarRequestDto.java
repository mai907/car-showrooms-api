package com.car.showrooms.dto;


import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarRequestDto {

    @NotBlank
    @Size(max = 25)
    private String vin;

    @NotBlank
    @Size(max = 25)
    private String maker;

    @NotBlank
    @Size(max = 25)
    private String model;

    @NotBlank
    @Size(min = 1, max = 15)
    @Pattern(regexp = "\\d{1,15}")
    private String modelYear;

    @NotNull
    private Double price;
}
