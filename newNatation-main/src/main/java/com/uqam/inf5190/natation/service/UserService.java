package com.uqam.inf5190.natation.service;


import com.uqam.inf5190.natation.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long userId);
}
