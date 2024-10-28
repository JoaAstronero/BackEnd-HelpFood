package com.joaquin.restaurante_crud.controllers;

import com.joaquin.restaurante_crud.dtos.userDTOs.SignInUserDTO;
import com.joaquin.restaurante_crud.dtos.userDTOs.UpdatePasswordDTO;
import com.joaquin.restaurante_crud.dtos.userDTOs.UserDTO;
import com.joaquin.restaurante_crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody SignInUserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        UserDTO userDTO = userService.getUserById(id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser() {
        List<UserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<UserDTO> deleteUserById(@RequestParam int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/profile")
    public ResponseEntity<UserDTO> updateUserProfile(@RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUserProfile(userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PutMapping("/password")
    public ResponseEntity<String> updatePassword(@RequestParam int userId, @RequestBody UpdatePasswordDTO updatePasswordDTO) {
        boolean isUpdated = userService.updatePassword(userId, updatePasswordDTO);
        if (isUpdated) {
            return new ResponseEntity<>("Constraseña Cambiada Exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error al cambiar de Contraseña!", HttpStatus.BAD_REQUEST);
        }
    }
}
