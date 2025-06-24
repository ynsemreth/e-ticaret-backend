package com.e_ticaret.backend.repository.User;

import com.e_ticaret.backend.entity.User.UserCurrencies;
import com.e_ticaret.backend.entity.User.UserCurrenciesId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCurrenciesRepository extends JpaRepository<UserCurrencies, UserCurrenciesId> {
    List<UserCurrencies> findByUserId(Long userId);
}
