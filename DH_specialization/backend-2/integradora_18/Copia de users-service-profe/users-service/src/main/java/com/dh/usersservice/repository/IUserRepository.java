package com.dh.usersservice.repository;

import com.dh.usersservice.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

  User update(String id, User user);
}
