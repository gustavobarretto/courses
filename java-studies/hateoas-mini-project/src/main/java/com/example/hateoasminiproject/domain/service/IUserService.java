package com.example.hateoasminiproject.domain.service;

import com.example.hateoasminiproject.domain.filter.UserFilter;
import com.example.hateoasminiproject.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {

    User save(User user);
    User findById(String id);
    Page<User> findAll(UserFilter filter, Pageable pageable);
}
