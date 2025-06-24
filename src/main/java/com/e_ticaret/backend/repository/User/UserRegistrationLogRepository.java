package com.e_ticaret.backend.repository.User;

import com.e_ticaret.backend.entity.User.UserRegistrationLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRegistrationLogRepository extends JpaRepository<UserRegistrationLog, Long> {
    List<UserRegistrationLog> findByUserId(Long userId);
}
