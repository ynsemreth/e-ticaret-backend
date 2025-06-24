package com.e_ticaret.backend.entity.User;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLanguages {

    @EmbeddedId
    private UserLanguagesId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("languageId")
    @JoinColumn(name = "language_id")
    private Languages languages;
}
