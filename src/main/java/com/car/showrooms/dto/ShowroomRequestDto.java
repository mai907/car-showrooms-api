package com.car.showrooms.dto;


import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowroomRequestDto {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(min = 1, max = 15)
    @Pattern(regexp = "\\d{1,15}")
    private String commercialRegistrationNumber;

    @Size(max = 100)
    private String mangerName;

    @NotBlank
    @Size(min = 1, max = 15)
    @Pattern(regexp = "\\d{1,15}")
    private String contactNumber;

    @Size(max = 255)
    private String address;



}
