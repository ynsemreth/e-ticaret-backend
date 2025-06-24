package com.e_ticaret.backend.entity.User;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_email_verifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEmailVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_email_verifications_user"))
    private User user;

    @Column(name = "verification_token", nullable = false, length = 255)
    private String verificationToken;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "verified_at")
    private LocalDateTime verifiedAt;

    @Column(name = "is_expired", nullable = false)
    private final boolean isExpired = false;
}
