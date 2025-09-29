package com.car.showrooms.services;

import com.car.showrooms.dto.ShowroomRequestDto;
import com.car.showrooms.dto.ShowroomResponseDto;
import com.car.showrooms.entity.Showroom;
import com.car.showrooms.mapper.ShowroomMapper;
import com.car.showrooms.repository.ShowroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShowroomServiceImpl implements ShowroomService {
    private ShowroomRepository showroomRepository;

    @Override
    public ShowroomResponseDto createShowroom(ShowroomRequestDto showroomDto) {
        Showroom showroom = ShowroomMapper.MAPPER.mapToShowroom(showroomDto);
        Showroom savedShowroom = showroomRepository.save(showroom);
        return ShowroomMapper.MAPPER.mapToShowroomResponseDto(savedShowroom);
    }

    @Override
    public List<ShowroomResponseDto> getAllShowrooms() {
        List<Showroom> showrooms =  showroomRepository.findByDeletedIsFalse();
        return showrooms.stream().map(ShowroomMapper.MAPPER::mapToShowroomResponseDto)
                .collect(Collectors.toList());

    }

    @Override
    public ShowroomResponseDto getShowroomById(Long id) {
        Showroom showroom = showroomRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new RuntimeException("Showroom not found"));
        return ShowroomMapper.MAPPER.mapToShowroomResponseDto(showroom);
    }

    @Override
    public ShowroomResponseDto updateShowroom(Long id, ShowroomRequestDto showroomDto) {
        Showroom showroom = showroomRepository.findByIdAndDeletedIsFalse(id).
                orElseThrow(() -> new RuntimeException("Showroom not found"));

        showroom.setContactNumber(Long.valueOf(showroomDto.getContactNumber()));
        showroom.setMangerName(showroomDto.getMangerName());
        showroom.setAddress(showroomDto.getAddress());

        Showroom savedShowroom = showroomRepository.save(showroom);
        return ShowroomMapper.MAPPER.mapToShowroomResponseDto(savedShowroom);
    }

    @Override
    public void deleteShowroom(Long id) {
        Showroom showroom = showroomRepository.findByIdAndDeletedIsFalse(id).
                orElseThrow(() -> new RuntimeException("Showroom not found"));
        showroom.setDeleted(true);
        showroomRepository.save(showroom);
    }
}
