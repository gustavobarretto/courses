package com.dh.usersservice.controller;

import com.dh.usersservice.model.User;
import com.dh.usersservice.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users/{userId}")
  public User getUser(@PathVariable  String userId){
    return  userService.findUser(userId);
  }
}
