package com.car.showrooms.mapper;

import com.car.showrooms.dto.UserResponseDto;
import com.car.showrooms.entity.Role;
import com.car.showrooms.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "role", expression = "java(mapRoles(user.getRoles()))")
    UserResponseDto mapToUserResponseDto(User user);

    default List<String> mapRoles(Set<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toList());
    }


}
