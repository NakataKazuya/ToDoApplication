package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

  void insert(User user);
  User loadUserByUsername(User user) throws EmptyResultDataAccessException;
}
