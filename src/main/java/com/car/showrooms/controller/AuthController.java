package com.car.showrooms.controller;


import com.car.showrooms.dto.UserRequestDto;
import com.car.showrooms.dto.UserResponseDto;
import com.car.showrooms.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@AllArgsConstructor
public class AuthController {
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<UserResponseDto> logIn (@Valid @RequestBody UserRequestDto userDto) {
        UserResponseDto responseDto = userService.getUser(userDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
