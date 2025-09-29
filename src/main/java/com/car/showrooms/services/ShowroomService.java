package com.car.showrooms.services;

import com.car.showrooms.dto.ShowroomRequestDto;
import com.car.showrooms.dto.ShowroomResponseDto;
import com.car.showrooms.entity.Showroom;

import java.util.List;
import java.util.Optional;

public interface ShowroomService {

    ShowroomResponseDto createShowroom(ShowroomRequestDto showroomDto);

    List<ShowroomResponseDto>  getAllShowrooms();

   ShowroomResponseDto getShowroomById(Long id);

   ShowroomResponseDto updateShowroom(Long id, ShowroomRequestDto showroomDto);

   void deleteShowroom(Long id);


}
