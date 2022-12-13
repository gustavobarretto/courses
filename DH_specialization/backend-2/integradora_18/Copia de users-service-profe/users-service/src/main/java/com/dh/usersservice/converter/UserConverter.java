package com.dh.usersservice.converter;

import com.dh.usersservice.dto.UserDTO;
import com.dh.usersservice.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserConverter {

    User userDTOToUser(UserDTO userDTO);

    UserDTO userToUserTO(User user);
}
