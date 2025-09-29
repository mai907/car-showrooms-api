package com.car.showrooms.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowroomResponseDto {

    private Long id;
    private String name;
    private Integer commercialRegistrationNumber;
    private String mangerName;
    private Integer contactNumber;
    private String address;

}
