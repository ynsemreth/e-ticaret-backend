package com.e_ticaret.backend.entity.User;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "currencies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Currencies {

    @Id
    @Column(length = 5)
    private String code;

    @Column(name = "symbol",nullable = false, unique = true, length = 5)
    private String symbol ;

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @OneToMany(mappedBy = "currencies", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<UserCurrencies> userCurrencies = new HashSet<>();
}

