package com.is_challenge.is_challenge.apiUser.service.impl;

import com.is_challenge.is_challenge.apiUser.entity.User;
import com.is_challenge.is_challenge.apiUser.exception.UserNotFoundException;
import com.is_challenge.is_challenge.apiUser.service.UserService;
import com.is_challenge.is_challenge.apiUser.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.findById(id).orElseThrow( () -> new UserNotFoundException("You can not delete an user with id " + id + " because this id does not exists!"));
        userRepository.deleteById(id);

    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow( () -> new UserNotFoundException("User with id " + id + " not found!"));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
