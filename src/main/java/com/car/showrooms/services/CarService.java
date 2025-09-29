package com.car.showrooms.services;


import com.car.showrooms.dao.CarSearchRequest;
import com.car.showrooms.dto.CarRequestDto;
import com.car.showrooms.dto.CarResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarService {
    CarResponseDto createCar(Long id, CarRequestDto carRequestDto);

    Page<CarResponseDto> getAllCars(int page, int size, CarSearchRequest searchRequest);
}
