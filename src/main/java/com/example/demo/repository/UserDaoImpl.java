package com.example.demo.repository;

import com.example.demo.entity.User;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

  private final JdbcTemplate jdbcTemplate;

  public UserDaoImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insert(User user) {
    try {
      jdbcTemplate.update("INSERT INTO user(username, email, password, enabled, authority) VALUES(?, ?, ?, ?, ?)",
        user.getUsername(), user.getEmail(), user.getPassword(), user.isEnabled(), user.getAuthority());
      return 1;
    } catch (EmptyResultDataAccessException e) {
      return 0;
    }
  }

}
