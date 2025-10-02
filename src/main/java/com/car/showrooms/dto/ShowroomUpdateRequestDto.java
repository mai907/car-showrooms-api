package com.car.showrooms.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowroomUpdateRequestDto {

    @Size(max = 100)
    private String mangerName;

    @NotBlank
    @Size(min = 1, max = 15)
    @Pattern(regexp = "\\d{1,15}")
    private String contactNumber;

    @Size(max = 255)
    private String address;



}
