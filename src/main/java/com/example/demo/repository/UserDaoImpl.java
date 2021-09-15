package com.example.demo.repository;

import com.example.demo.entity.User;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

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

  @Override
  public Optional<User> findUser(User user) {
    String sql = "SELECT id, username, email, password, enabled, authority FROM user "
            + "WHERE username = ? AND password = ? AND enabled = 1";
    String username = user.getUsername();
    String password = user.getPassword();
    Map<String, Object> result = jdbcTemplate.queryForMap(sql, username, password);

    User loginUser = new User();
    loginUser.setId((int) result.get("id"));
    loginUser.setUsername((String) result.get("username"));
    loginUser.setEmail((String) result.get("email"));
    loginUser.setPassword((String) result.get("password"));
    loginUser.setEnabled(true);
    loginUser.setAuthority((String) result.get("authority"));

    Optional<User> userDetail = Optional.ofNullable(loginUser);

    return userDetail;
  }

}
