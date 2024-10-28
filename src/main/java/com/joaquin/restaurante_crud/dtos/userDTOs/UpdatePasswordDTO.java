package com.joaquin.restaurante_crud.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordDTO {
    private String currentPassword;
    private String newPassword;
    private String confirmedNewPassword;
}
