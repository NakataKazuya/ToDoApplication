package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserDao;

import org.springframework.stereotype.Service;

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
  
}
