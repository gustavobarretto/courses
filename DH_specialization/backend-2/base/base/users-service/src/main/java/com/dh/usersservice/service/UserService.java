package com.dh.usersservice.service;

import com.dh.usersservice.model.User;
import com.dh.usersservice.repository.IClaimFeignRepository;
import com.dh.usersservice.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private IUserRepository userRepository;
  private IClaimFeignRepository claimFeignRepository;

  public UserService(IUserRepository userRepository,IClaimFeignRepository claimFeignRepository) {
    this.userRepository = userRepository;
    this.claimFeignRepository = claimFeignRepository;
  }

  public User findUser(String userId) {
    User user = userRepository.findById(userId);
    user.setClaims(claimFeignRepository.getClaims(user.getId()));
    return user;
  }
}
