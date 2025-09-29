package com.car.showrooms.mapper;


import com.car.showrooms.dto.ShowroomRequestDto;
import com.car.showrooms.dto.ShowroomResponseDto;
import com.car.showrooms.entity.Showroom;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShowroomMapper {

    ShowroomMapper MAPPER = Mappers.getMapper(ShowroomMapper.class);

    @Mapping(source = "commercialRegistrationNumber", target = "cmr")
    Showroom mapToShowroom(ShowroomRequestDto showroomRequestDto);

    @Mapping(source = "cmr", target = "commercialRegistrationNumber")
    ShowroomResponseDto mapToShowroomResponseDto(Showroom showroom);
}
