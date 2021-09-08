package com.example.demo.repository;

import com.example.demo.entity.User;

import java.util.Optional;

public interface UserDao {
  int insert(User user);
  Optional<User> findUser(User user);
}
