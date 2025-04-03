package org.example.scheduledevelop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class LoginRequestDto {

    // 사용자가 입력한 아이디
    @NotBlank
    private final String email;
    // 사용자가 입력한 비밀번호
    @NotNull
    private final String password;
}
