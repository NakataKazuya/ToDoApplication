package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserDao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private final UserDao dao;

  public UserServiceImpl(UserDao dao) {
    this.dao = dao;
  }

  @Override
  public void insert(User user) {
    dao.insert(user);
  }

  @Override
  public User loadUserByUsername(User user) throws EmptyResultDataAccessException {

    try {
      return dao.findUser(user).get();
    } catch (EmptyResultDataAccessException e) {
      throw new TaskNotFoundException("誤りです");
    }
  }

}
