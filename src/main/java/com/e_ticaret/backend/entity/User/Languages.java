package com.e_ticaret.backend.entity.User;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Languages {

    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code",nullable = false, unique = true, length = 50)
    private String code ;

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @OneToMany(mappedBy = "languages", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<UserLanguages> userLanguages = new HashSet<>();

}
