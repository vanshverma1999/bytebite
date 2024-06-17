package com.bytebite.user_service.controller;

import com.bytebite.user_service.model.UserDetails;
import com.bytebite.user_service.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDetails> createUser(@RequestBody UserDetails userDetails) {
        return ResponseEntity.status(201).body(userService.createUser(userDetails));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDetails> getUserById(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping
    public ResponseEntity<UserDetails> getUserByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDetails> updateUser(@PathVariable Long userId, @RequestBody UserDetails userDetails) {
        return ResponseEntity.ok(userService.updateUser(userId, userDetails));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted with id: " + userId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDetails>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
