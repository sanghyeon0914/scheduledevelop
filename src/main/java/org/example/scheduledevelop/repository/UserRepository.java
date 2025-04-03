package org.example.scheduledevelop.repository;

import org.example.scheduledevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    default User findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }

    // 이메일 + 패스워드로 사용자 조회
    Optional<User> findByEmailAndPassword(String email, String password);

    // Optional 처리 후 예외 던지는 default 메서드
    default Long findIdByEmailAndPasswordOrElseThrow(String email, String password) {
        return findByEmailAndPassword(email, password)
                .map(User::getId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "이메일 또는 비밀번호가 일치하지 않습니다."));
        }

}




