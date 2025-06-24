package com.e_ticaret.backend.repository.User;

import com.e_ticaret.backend.entity.User.UserEmailVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserEmailVerificationRepository extends JpaRepository<UserEmailVerification, Long> {
    Optional<UserEmailVerification> findByVerificationToken(String token);
    Optional<UserEmailVerification> findFirstByUserIdOrderByCreatedAtDesc(Long userId);
}
