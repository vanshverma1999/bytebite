package com.bytebite.user_service.service;


import com.bytebite.user_service.model.UserDetails;

import java.util.List;

public interface IUserService {
    UserDetails createUser(UserDetails UserDetails);

    UserDetails getUserById(Long userId);

    UserDetails getUserByEmail(String email);

    UserDetails updateUser(Long userId, UserDetails UserDetails);

    void deleteUser(Long userId);

    List<UserDetails> getAllUsers();

    List<UserDetails> searchUsers(String query);
}
