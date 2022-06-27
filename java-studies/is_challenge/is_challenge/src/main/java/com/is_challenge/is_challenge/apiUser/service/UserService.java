package com.is_challenge.is_challenge.apiUser.service;

import com.is_challenge.is_challenge.apiUser.entity.User;

import java.util.List;

public interface UserService {

    User create(User user);
    void delete(Long id);
    User get(Long id);
    List<User> getAll();

}
