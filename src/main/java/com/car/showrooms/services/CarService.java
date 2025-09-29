package com.car.showrooms.services;


import com.car.showrooms.dto.CarRequestDto;
import com.car.showrooms.dto.CarResponseDto;

import java.util.List;

public interface CarService {
    CarResponseDto createCar(Long id, CarRequestDto carRequestDto);

    List<CarResponseDto> getAllCars();
}
