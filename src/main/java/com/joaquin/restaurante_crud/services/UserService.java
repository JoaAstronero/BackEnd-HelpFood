package com.joaquin.restaurante_crud.services;

import com.joaquin.restaurante_crud.dtos.userDTOs.SignInUserDTO;
import com.joaquin.restaurante_crud.dtos.userDTOs.UpdatePasswordDTO;
import com.joaquin.restaurante_crud.dtos.userDTOs.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(SignInUserDTO userDTO);
    UserDTO updateUserProfile(UserDTO userDTO);
    boolean updatePassword(int userId, UpdatePasswordDTO updatePasswordDTO);
    UserDTO getUserById(int id);
    List<UserDTO> getAllUsers();
    boolean deleteUser(int id);
}
