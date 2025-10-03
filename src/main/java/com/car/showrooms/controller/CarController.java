package com.car.showrooms.controller;


import com.car.showrooms.dao.CarSearchRequest;
import com.car.showrooms.dto.CarRequestDto;
import com.car.showrooms.dto.CarResponseDto;
import com.car.showrooms.services.CarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/showroom/car")
@AllArgsConstructor
public class CarController {
    private CarService carService;

    //    6.	Create new Car in Car Showroom API
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("{showroomId}")
    public ResponseEntity<CarResponseDto> createCarShowroomById (@PathVariable("showroomId") Long id,
                                                              @Valid @RequestBody CarRequestDto carDto) {
        CarResponseDto responseDto = carService.createCar(id, carDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    //    7.	List Cars with Showroom Details API
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping
    public ResponseEntity<Page<CarResponseDto>> getAllCarsWithShowroom (@RequestParam(defaultValue = "1") int pageNo,
                                                                        @RequestParam(defaultValue = "10") int pageSize,
                                                                        @RequestBody CarSearchRequest searchRequest) {
        Page<CarResponseDto> cars = carService.getAllCars(pageNo, pageSize, searchRequest);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
}
