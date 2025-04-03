package org.example.scheduledevelop.service;

import lombok.RequiredArgsConstructor;
import org.example.scheduledevelop.dto.ScheduleResponseDto;
import org.example.scheduledevelop.entity.Schedule;
import org.example.scheduledevelop.entity.User;
import org.example.scheduledevelop.repository.ScheduleRepository;
import org.example.scheduledevelop.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto save(Long id, String title, String contents) {

        // 1. 유저 ID로 유저 조회
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.UNAUTHORIZED,
                                "Does not exist userId = " + id
                        )
                );

        Schedule schedule = new Schedule(title, contents);
        schedule.setUser(user);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getContents());

    }

    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    @Transactional
    public void update(long id, Long userId, String title) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        if (!schedule.getUser().getId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "사용자 이름이 일치하지 않아 수정할 수 없습니다.");
        }

        schedule.update(title);

    }

    public void delete(Long id, Long userId){

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        if (!schedule.getUser().getId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "사용자 이름이 일치하지 않아 수정할 수 없습니다.");
        }

        scheduleRepository.delete(schedule);

        }

}
