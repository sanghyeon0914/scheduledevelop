package org.example.scheduledevelop.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.scheduledevelop.common.Const;
import org.example.scheduledevelop.dto.LoginResponseDto;
import org.example.scheduledevelop.dto.ScheduleRequestDto;
import org.example.scheduledevelop.dto.ScheduleResponseDto;
import org.example.scheduledevelop.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor

public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping()
    public ResponseEntity<ScheduleResponseDto> save(
            @RequestBody @Valid ScheduleRequestDto requestDto,
            HttpServletRequest request
    ){
        HttpSession session = request.getSession();
        session.getAttribute(Const.LOGIN_USER);

        LoginResponseDto login = (LoginResponseDto) session.getAttribute(Const.LOGIN_USER);

        ScheduleResponseDto scheduleResponseDto = scheduleService.save(login.getId(), requestDto.getTitle(), requestDto.getContents() );

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){

        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    //할일 수정
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> update(
            @PathVariable long id,
            @RequestBody ScheduleRequestDto requestDto,
            HttpServletRequest request
    ){

        HttpSession session = request.getSession();

        session.getAttribute(Const.LOGIN_USER);

        LoginResponseDto login = (LoginResponseDto) session.getAttribute(Const.LOGIN_USER);

        scheduleService.update(id, login.getId(),requestDto.getTitle());

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.getAttribute(Const.LOGIN_USER);

        LoginResponseDto login = (LoginResponseDto) session.getAttribute(Const.LOGIN_USER);

        scheduleService.delete(id, login.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
