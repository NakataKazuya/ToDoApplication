package com.example.demo.repository;

import com.example.demo.entity.User;

import java.util.Optional;

public interface IUserAccountDao {
    Optional<User> findUser(String username);
}
