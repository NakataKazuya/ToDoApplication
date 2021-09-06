package com.example.demo.repository;

import com.example.demo.entity.User;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

  private final JdbcTemplate jdbcTemplate;

  public UserDaoImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void insert(User user) {
    jdbcTemplate.update("INSERT INTO user(username, email, password, enabled, authority) VALUES(?, ?, ?, ?, ?)",
        user.getUsername(), user.getEmail(), user.getPassword(), user.isEnabled(), user.getAuthority());
  }

}
