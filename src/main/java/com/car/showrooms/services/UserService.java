package com.car.showrooms.services;

import com.car.showrooms.dto.UserRequestDto;
import com.car.showrooms.dto.UserResponseDto;

public interface UserService {
    UserResponseDto getUser(UserRequestDto carRequestDto);

}
