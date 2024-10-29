package com.joaquin.restaurante_crud.mappers;

import com.joaquin.restaurante_crud.dtos.userDTOs.SignInUserDTO;
import com.joaquin.restaurante_crud.dtos.userDTOs.UserDTO;
import com.joaquin.restaurante_crud.entities.User;

public class UserMapper {
    public static UserDTO toUserDto(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
    public static User toUser(SignInUserDTO signInUserDTO) {
        if (signInUserDTO == null) {
            return null;
        }
        User user = new User();
        user.setId(signInUserDTO.getId());
        user.setUsername(signInUserDTO.getUsername());
        user.setEmail(signInUserDTO.getEmail());
        user.setPassword(signInUserDTO.getPassword());
        return user;
    }
}
