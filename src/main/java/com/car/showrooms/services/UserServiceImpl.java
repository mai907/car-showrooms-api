package com.car.showrooms.services;


import com.car.showrooms.dto.UserRequestDto;
import com.car.showrooms.dto.UserResponseDto;
import com.car.showrooms.mapper.UserMapper;
import com.car.showrooms.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;

    @Override
    public UserResponseDto getUser(UserRequestDto carRequestDto){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            carRequestDto.getUsername(),
                            carRequestDto.getPassword()
                    )
            );
            var user = userRepository.findByUsernameOrEmail(carRequestDto.getUsername(), carRequestDto.getUsername());
            return UserMapper.MAPPER.mapToUserResponseDto(user.get());
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }
    }

}
