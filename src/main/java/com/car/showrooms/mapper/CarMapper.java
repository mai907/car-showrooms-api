package com.car.showrooms.mapper;


import com.car.showrooms.dto.CarRequestDto;
import com.car.showrooms.dto.CarResponseDto;
import com.car.showrooms.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper MAPPER = Mappers.getMapper(CarMapper.class);

    Car mapToCar(CarRequestDto carRequestDto);

    @Mapping(source ="price" , target = "amount")
    @Mapping(source ="showroom.name" , target = "carShowroomName")
    @Mapping(source ="showroom.contactNumber" , target = "contactNumber")
    CarResponseDto mapToCarResponseDto(Car car);

}
