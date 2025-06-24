package com.e_ticaret.backend.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCurrenciesId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "currency_code")
    private String currencyCode;
}
