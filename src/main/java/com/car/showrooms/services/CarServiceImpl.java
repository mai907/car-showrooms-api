package com.car.showrooms.services;

import com.car.showrooms.dto.CarRequestDto;
import com.car.showrooms.dto.CarResponseDto;
import com.car.showrooms.entity.Car;
import com.car.showrooms.entity.Showroom;
import com.car.showrooms.exception.ResourceNotFoundException;
import com.car.showrooms.mapper.CarMapper;
import com.car.showrooms.repository.CarRepository;
import com.car.showrooms.repository.ShowroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private ShowroomRepository showroomRepository;

    @Override
    public CarResponseDto createCar(Long id, CarRequestDto carRequestDto) {
        Showroom showroom = showroomRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("The requested Showroom could not be found with id: " + id));
        Car car = CarMapper.MAPPER.mapToCar(carRequestDto);
        car.setShowroom(showroom);
        Car savedCar = carRepository.save(car);
        return CarMapper.MAPPER.mapToCarResponseDto(savedCar);
    }

    @Override
    public Page<CarResponseDto> getAllCars(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Car> cars = carRepository.findByShowroom_DeletedFalse(pageable);
       var dtoList =  cars.stream().map(CarMapper.MAPPER::mapToCarResponseDto)
                .collect(Collectors.toList());
         return new PageImpl<>(dtoList, cars.getPageable(), cars.getTotalElements());
    }

}
