package com.car.showrooms.services;

import com.car.showrooms.dto.ShowroomRequestDto;
import com.car.showrooms.dto.ShowroomResponseDto;
import com.car.showrooms.dto.ShowroomUpdateRequestDto;
import com.car.showrooms.entity.Showroom;
import com.car.showrooms.exception.CMRAlreadyExistsException;
import com.car.showrooms.exception.ResourceNotFoundException;
import com.car.showrooms.mapper.ShowroomMapper;
import com.car.showrooms.repository.ShowroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShowroomServiceImpl implements ShowroomService {
    private ShowroomRepository showroomRepository;

    @Override
    public ShowroomResponseDto createShowroom(ShowroomRequestDto showroomDto) {

        Optional<Showroom> optionalShowroom = showroomRepository
                .findByCmr(Long.valueOf(showroomDto.getCommercialRegistrationNumber()));

        if (optionalShowroom.isPresent()) {
            throw new CMRAlreadyExistsException();
        }

        Showroom showroom = ShowroomMapper.MAPPER.mapToShowroom(showroomDto);
        Showroom savedShowroom = showroomRepository.save(showroom);
        return ShowroomMapper.MAPPER.mapToShowroomResponseDto(savedShowroom);
    }

    @Override
    public Page<ShowroomResponseDto> getAllShowrooms(int page, int size, String sortBy, String order) {
        Sort sort = order.equalsIgnoreCase("ASC") ?
                 Sort.by(sortBy).ascending()
                :Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page-1, size, sort);

        Page<Showroom> showrooms =  showroomRepository.findByDeletedIsFalse(pageable);

         List <ShowroomResponseDto> dtoList = showrooms.stream()
                 .map(ShowroomMapper.MAPPER::mapToShowroomResponseDto)
                 .collect(Collectors.toList());

         return new PageImpl<>(dtoList, showrooms.getPageable(), showrooms.getTotalElements());

    }

    @Override
    public ShowroomResponseDto getShowroomById(Long id) {
        Showroom showroom = showroomRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("The requested Showroom was not found when retrieving with id: " + id));
        return ShowroomMapper.MAPPER.mapToShowroomResponseDto(showroom);
    }

    @Override
    public ShowroomResponseDto updateShowroom(Long id, ShowroomUpdateRequestDto showroomDto) {
        Showroom showroom = showroomRepository.findByIdAndDeletedIsFalse(id).
                orElseThrow(() -> new ResourceNotFoundException("The requested Showroom was not found when updating with id: " + id));

        showroom.setContactNumber(Long.valueOf(showroomDto.getContactNumber()));
        showroom.setMangerName(showroomDto.getMangerName());
        showroom.setAddress(showroomDto.getAddress());

        Showroom savedShowroom = showroomRepository.save(showroom);
        return ShowroomMapper.MAPPER.mapToShowroomResponseDto(savedShowroom);
    }

    @Override
    public void deleteShowroom(Long id) {
        Showroom showroom = showroomRepository.findByIdAndDeletedIsFalse(id).
                orElseThrow(() -> new ResourceNotFoundException("The requested Showroom was not found when deleting with ID id: " + id));
        showroom.setDeleted(true);
        showroomRepository.save(showroom);
    }

    @Override
    public List<ShowroomResponseDto> getAllShowrooms() {
        List<Showroom> showroom =  showroomRepository.findAll();
        return  showroom.stream()
                .map(ShowroomMapper.MAPPER::mapToShowroomResponseDto)
                .collect(Collectors.toList());
    }
}
