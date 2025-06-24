package com.e_ticaret.backend.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserLanguagesId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "language_id")
    private Long languageId;
}
