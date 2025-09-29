package com.car.showrooms.controller;


import com.car.showrooms.dto.CarRequestDto;
import com.car.showrooms.dto.CarResponseDto;
import com.car.showrooms.entity.Car;
import com.car.showrooms.services.CarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/showroom/car")
@AllArgsConstructor
public class CarController {
    private CarService carService;

    //    6.	Create new Car in Car Showroom API
    @PostMapping("{showroomId}")
    public ResponseEntity<CarResponseDto> updateShowroomById (@PathVariable("showroomId") Long id,
                                                              @Valid @RequestBody CarRequestDto carDto) {
        CarResponseDto responseDto = carService.createCar(id, carDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    //    7.	List Cars with Showroom Details API
    @GetMapping
    public ResponseEntity<List<CarResponseDto>> getAllCarsWithShowroom () {
        List<CarResponseDto> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
}
