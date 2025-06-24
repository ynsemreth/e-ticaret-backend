package com.e_ticaret.backend.entity.User;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_currencies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCurrencies {

    @EmbeddedId
    private UserCurrenciesId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("currencyCode")
    @JoinColumn(name = "currency_code")
    private Currencies currencies;
}
