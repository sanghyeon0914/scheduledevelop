package org.example.scheduledevelop.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.scheduledevelop.common.Const;
import org.example.scheduledevelop.dto.LoginRequestDto;
import org.example.scheduledevelop.dto.LoginResponseDto;
import org.example.scheduledevelop.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login (@RequestBody LoginRequestDto reqestDto, HttpServletRequest request){

        LoginResponseDto login = userService.login(reqestDto.getEmail(), reqestDto.getPassword());

        // 로그인 성공시 로직
        // Session의 Default Value는 true이다.
        // Session이 request에 존재하면 기존의 Session을 반환하고,
        // Session이 request에 없을 경우에 새로 Session을 생성한다.
        HttpSession session = request.getSession();

        // Session에 로그인 회원 정보를 저장한다.
        session.setAttribute(Const.LOGIN_USER, login);

        // 로그인 성공시 리다이렉트
        return new ResponseEntity<>(login, HttpStatus.OK);

    }
}