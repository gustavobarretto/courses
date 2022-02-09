package com.example.javachallenge.service;

import com.example.javachallenge.model.User;
import com.example.javachallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public User desactivateAccount(Integer id, Boolean status) {
        User userDesactivated = userRepository.findById(id).get();
        userDesactivated.setStatusAccount(status);
        return userRepository.saveAndFlush(userDesactivated);
    }

    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    public User get(Integer id) {
        return userRepository.findById(id).get();
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

}
