package com.uqam.inf5190.natation.service;

import com.uqam.inf5190.natation.dao.UserRepository;
import com.uqam.inf5190.natation.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImplem implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> userObj = this.userRepository.findById(userId);
        return userObj.get();
    }
}
