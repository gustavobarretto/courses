package com.example.hateoasminiproject.domain.repository;

import com.example.hateoasminiproject.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    boolean existsByEmail(String email);
}
