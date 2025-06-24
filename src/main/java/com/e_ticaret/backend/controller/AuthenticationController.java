package com.e_ticaret.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_ticaret.backend.dto.User.GetUserResponse;
import com.e_ticaret.backend.dto.User.UserDto;
import com.e_ticaret.backend.dto.User.UserRequestDto;
import com.e_ticaret.backend.dto.User.UserResponse;
import com.e_ticaret.backend.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/save")
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(authenticationService.saveUser(userDto));
    }

    @PostMapping("/auth")
    public ResponseEntity<UserResponse> auth(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(authenticationService.auth(userRequestDto));
    }

    @GetMapping("/get-user")
    public ResponseEntity<List<GetUserResponse>> getUser() {
        return ResponseEntity.ok(authenticationService.getUser());
    }

    @GetMapping("/get-role/{role}")
    public ResponseEntity<List<GetUserResponse>> getRole(@PathVariable String role) {
        return ResponseEntity.ok(authenticationService.getRole(role));
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<String> updateUser(@PathVariable String username, @RequestBody UserDto userDto) {
        authenticationService.updateUser(username, userDto);
        return ResponseEntity.ok("ok");
    }

}
