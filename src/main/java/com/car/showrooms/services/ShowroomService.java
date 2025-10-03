package com.car.showrooms.services;

import com.car.showrooms.dto.ShowroomRequestDto;
import com.car.showrooms.dto.ShowroomResponseDto;
import com.car.showrooms.dto.ShowroomUpdateRequestDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ShowroomService {

    ShowroomResponseDto createShowroom(ShowroomRequestDto showroomDto);

    Page<ShowroomResponseDto> getAllShowrooms(int page, int size, String sortBy, String order);

   ShowroomResponseDto getShowroomById(Long id);

   ShowroomResponseDto updateShowroom(Long id, ShowroomUpdateRequestDto showroomDto);

   void deleteShowroom(Long id);

    List<ShowroomResponseDto> getAllShowrooms();


}
