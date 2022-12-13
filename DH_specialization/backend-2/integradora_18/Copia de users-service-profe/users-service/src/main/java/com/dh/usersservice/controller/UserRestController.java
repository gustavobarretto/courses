package com.dh.usersservice.controller;

import com.dh.usersservice.converter.UserConverter;
import com.dh.usersservice.dto.UserDTO;
import com.dh.usersservice.model.User;

import com.dh.usersservice.service.UserService;
import org.jboss.resteasy.annotations.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("users")
public class UserRestController {
  @Autowired
  private UserService userService;
  @Autowired
  private UserConverter converter;

  @PatchMapping("{id}")
  public UserDTO update(@PathVariable  String id, @RequestBody UserDTO userDTO){
    return converter.userToUserTO(userService
            .update(id, converter.userDTOToUser(userDTO)));
  }



}
