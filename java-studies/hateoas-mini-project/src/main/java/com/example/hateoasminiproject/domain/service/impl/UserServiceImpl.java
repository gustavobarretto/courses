package com.example.hateoasminiproject.domain.service.impl;

import com.example.hateoasminiproject.domain.exception.EmailAlreadyInUseExeception;
import com.example.hateoasminiproject.domain.exception.UserNotFoundException;
import com.example.hateoasminiproject.domain.filter.UserFilter;
import com.example.hateoasminiproject.domain.model.User;
import com.example.hateoasminiproject.domain.repository.IUserRepository;
import com.example.hateoasminiproject.domain.repository.specification.UserSpecification;
import com.example.hateoasminiproject.domain.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository repository;

    @Override
    public User save(User user) {
        return user.isNew() ? createUser(user) : updateUser(user);
    }

    @Override
    public User findById(String id) {
        return repository.findById(id).orElseThrow( () -> new UserNotFoundException(id));
    }

    @Override
    public Page<User> findAll(UserFilter filter, Pageable pageable) {
        return repository.findAll(UserSpecification.filterUser(filter), pageable);
    }


    public User createUser(User user) {
        if(repository.existsByEmail(user.getEmail())) throw new EmailAlreadyInUseExeception(user.getEmail());
        user = repository.save(user);
        repository.flush();
        return user;
    }

    public User updateUser(User user) {
        user = repository.save(user);
        repository.flush();
        return user;
    }
}
