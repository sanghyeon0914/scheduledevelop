package org.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {
    private final String username;

    private final String email;

    private final String oldPassword;

    private final String newPassword;

    public UserRequestDto(String username, String email, String oldPassword, String newPassword){
        this.username = username;
        this.email = email;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}
