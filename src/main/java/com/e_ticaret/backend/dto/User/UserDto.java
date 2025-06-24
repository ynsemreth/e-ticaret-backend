package com.e_ticaret.backend.dto.User;

import com.e_ticaret.backend.entity.User.User.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String firstname;
    private String lastname;
    private String password;
    private String username;
    private String email;
    private Role role;
    private String phoneNumber;
    private String profileImage;
    private String companyName;
    private String country;
    private String city;
    private String address;
}
