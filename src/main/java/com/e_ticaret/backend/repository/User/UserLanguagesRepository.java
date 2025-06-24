package com.e_ticaret.backend.repository.User;

import com.e_ticaret.backend.entity.User.UserLanguages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserLanguagesRepository extends JpaRepository<UserLanguages, Long> {
    List<UserLanguages> findByUserId(Long userId);
}
