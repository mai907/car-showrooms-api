package com.car.showrooms.controller;

import com.car.showrooms.dto.ShowroomRequestDto;
import com.car.showrooms.dto.ShowroomResponseDto;
import com.car.showrooms.dto.ShowroomUpdateRequestDto;
import com.car.showrooms.services.ShowroomService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/showroom")
@AllArgsConstructor
public class ShowroomController {
    private ShowroomService showroomService;

//1.	Create Car Showroom API
@PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ShowroomResponseDto> createShowroom (@RequestBody @Valid ShowroomRequestDto showroomDto) {
        ShowroomResponseDto showroomResDto = showroomService.createShowroom(showroomDto);
        return new ResponseEntity<>(showroomResDto, HttpStatus.CREATED);

    }

//2.	List Car Showrooms API
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<Page<ShowroomResponseDto>> getAllShowroom (@RequestParam(defaultValue = "1") int pageNo,
                                                                     @RequestParam(defaultValue = "10") int pageSize,
                                                                     @RequestParam(defaultValue = "id") String sortBy,
                                                                     @RequestParam(defaultValue = "ASC") String sortDir) {
        Page<ShowroomResponseDto> Showrooms =  showroomService.getAllShowrooms(pageNo, pageSize, sortBy, sortDir );
        return new ResponseEntity<>(Showrooms, HttpStatus.OK);
    }

//3.	Get Specific Car Showroom API
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("{id}")
    public ResponseEntity<ShowroomResponseDto> getShowroom (@PathVariable Long id) {
        ShowroomResponseDto showroomResDto =  showroomService.getShowroomById(id);
        return new ResponseEntity<>(showroomResDto, HttpStatus.OK);
    }

//4.	Update Car Showroom API
@PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("{id}")
    public ResponseEntity<ShowroomResponseDto> updateShowroomById (@PathVariable Long id,
                                                                   @Valid @RequestBody ShowroomUpdateRequestDto ShowroomDto) {
        ShowroomResponseDto showroomResDto = showroomService.updateShowroom(id, ShowroomDto);
        return new ResponseEntity<>(showroomResDto, HttpStatus.OK);
    }

//5.	Delete Car Showroom API
@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteShowroomById (@PathVariable Long id) {
        showroomService.deleteShowroom(id);
       return  ResponseEntity.ok().build();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list")
    public ResponseEntity<List<ShowroomResponseDto>> getAllShowroom () {
        List<ShowroomResponseDto> Showrooms =  showroomService.getAllShowrooms();
        return new ResponseEntity<>(Showrooms, HttpStatus.OK);
    }









}
