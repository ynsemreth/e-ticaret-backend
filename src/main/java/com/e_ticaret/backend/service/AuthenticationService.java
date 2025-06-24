package com.e_ticaret.backend.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.e_ticaret.backend.dto.User.GetUserResponse;
import com.e_ticaret.backend.dto.User.UserDto;
import com.e_ticaret.backend.dto.User.UserRequestDto;
import com.e_ticaret.backend.dto.User.UserResponse;
import com.e_ticaret.backend.entity.User.User;
import com.e_ticaret.backend.entity.User.User.Role;
import com.e_ticaret.backend.repository.User.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public UserResponse saveUser(UserDto userDto) {
        User user = User.builder().firstName(userDto.getFirstname())
                        .lastName(userDto.getLastname())
                        .username(userDto.getUsername())
                        .email(userDto.getEmail())
                        .password(passwordEncoder.encode(userDto.getPassword()))
                        .phoneNumber(userDto.getPhoneNumber())
                        .profileImage(userDto.getProfileImage())
                        .companyName(userDto.getCompanyName())
                        .country(userDto.getCountry())
                        .city(userDto.getCity())
                        .address(userDto.getAddress())
                        .role(userDto.getRole()).build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return UserResponse.builder().token(jwtToken)
                            .build();
    }

    public UserResponse auth(UserRequestDto userRequestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequestDto.getUsername(), userRequestDto.getPassword()));
        User user = userRepository.findByUsername(userRequestDto.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        return UserResponse.builder().token(token).build();
    }

    public List<GetUserResponse> getUser() {
        return userRepository.findAll().stream().filter(u -> u.getRole() == Role.GUEST)
            .map(u -> GetUserResponse.builder()
                .firstName(u.getFirstName())
                .lastName(u.getLastName())
                .username(u.getUsername())
                .role(u.getRole())
                .email(u.getEmail())
                .phoneNumber(u.getPhoneNumber())
                .profileImage(u.getProfileImage())
                .companyName(u.getCompanyName())
                .country(u.getCountry())
                .city(u.getCity())
                .address(u.getAddress())
                .build()).toList();
    }

    public List<GetUserResponse> getRole(String role) {
        return userRepository.findAll().stream()
            .filter(u -> u.getRole().toString().equalsIgnoreCase(role))
            .map(u -> GetUserResponse.builder()
                .firstName(u.getFirstName())
                .lastName(u.getLastName())
                .username(u.getUsername())
                .role(u.getRole())
                .email(u.getEmail())
                .phoneNumber(u.getPhoneNumber())
                .profileImage(u.getProfileImage())
                .companyName(u.getCompanyName())
                .country(u.getCountry())
                .city(u.getCity())
                .address(u.getAddress())
                .build()).toList();
    }

    public String updateUser(String username, UserDto userDto) {
        User user = userRepository.findByUsername(username).orElseThrow();

        Optional.ofNullable(userDto.getFirstname()).ifPresent(user::setFirstName);
        Optional.ofNullable(userDto.getLastname()).ifPresent(user::setLastName);
        Optional.ofNullable(userDto.getUsername()).ifPresent(user::setUsername);
        Optional.ofNullable(userDto.getRole()).ifPresent(user::setRole);
        Optional.ofNullable(userDto.getEmail()).ifPresent(user::setEmail);
        Optional.ofNullable(userDto.getPhoneNumber()).ifPresent(user::setPhoneNumber);
        Optional.ofNullable(userDto.getProfileImage()).ifPresent(user::setProfileImage);
        Optional.ofNullable(userDto.getCompanyName()).ifPresent(user::setCompanyName);
        Optional.ofNullable(userDto.getCountry()).ifPresent(user::setCountry);
        Optional.ofNullable(userDto.getCity()).ifPresent(user::setCity);
        Optional.ofNullable(userDto.getAddress()).ifPresent(user::setAddress); 

        if (userDto.getPassword() != null){
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }

        user.setUpdatedAt(Timestamp.from(Instant.now()));

        return userRepository.save(user) != null ? "ok" : "error";

    } 
}
