package com.is_challenge.is_challenge.apiUser.repository;

import com.is_challenge.is_challenge.apiUser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
