package com.dh.usersservice.repository;

import com.dh.usersservice.model.User;

public interface IUserRepository {
  User findById(String id);
}
