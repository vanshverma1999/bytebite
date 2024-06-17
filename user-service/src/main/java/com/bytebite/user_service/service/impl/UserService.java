package com.bytebite.user_service.service.impl;

import com.bytebite.user_service.exception.UserNotFoundException;
import com.bytebite.user_service.model.UserDetails;
import com.bytebite.user_service.repository.UserRepository;
import com.bytebite.user_service.service.IRoleService;
import com.bytebite.user_service.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IRoleService roleService;

    @Override
    public UserDetails createUser(UserDetails userDetails) {
        userDetails.setPassword(encodePassword(userDetails.getPassword()));
        userDetails.setRole(roleService.findByName(userDetails.getRole().getRole()));
        return userRepository.save(userDetails);
    }

    @Override
    public UserDetails getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found id: " + userId));
    }

    @Override
    public UserDetails getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
    }

    @Override
    public UserDetails updateUser(Long userId, UserDetails userDetailsInput) {
        if (userId == null) {
            return createUser(userDetailsInput);
        }
        UserDetails userDetails = getUserById(userId);
        if (userDetailsInput.getAddress() != null) {
            userDetails.setAddress(userDetailsInput.getAddress());
        }
        if (userDetailsInput.getName() != null) {
            userDetails.setName(userDetailsInput.getName());
        }
        return userRepository.save(userDetails);
    }

    @Override
    public void deleteUser(Long userId) {
        UserDetails userDetails = getUserById(userId);
        userDetails.setDeleted(true);
        userRepository.save(userDetails);
    }

    @Override
    public List<UserDetails> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDetails> searchUsers(String query) {
        return userRepository.findByNameLike(query);
    }

    private String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}
