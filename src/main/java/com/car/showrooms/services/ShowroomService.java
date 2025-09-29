package com.car.showrooms.services;

import com.car.showrooms.dto.ShowroomRequestDto;
import com.car.showrooms.dto.ShowroomResponseDto;
import com.car.showrooms.entity.Showroom;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ShowroomService {

    ShowroomResponseDto createShowroom(ShowroomRequestDto showroomDto);

    Page<ShowroomResponseDto> getAllShowrooms(int page, int size, String sortBy, String order);

   ShowroomResponseDto getShowroomById(Long id);

   ShowroomResponseDto updateShowroom(Long id, ShowroomRequestDto showroomDto);

   void deleteShowroom(Long id);


}
