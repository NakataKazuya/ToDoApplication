package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserAccountDao implements IUserAccountDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findUser(String username) {
        String sql = "SELECT id, password, username FROM user WHERE username = ?";
        Map<String, Object> param = new HashMap<>();
        param.put("username", username);

        User user = new User();
        try {
            Map<String, Object> result = jdbcTemplate.queryForMap(sql,username);
            user.setId((int)result.get("id"));
            user.setPassword((String)result.get("password"));
            user.setUsername((String)result.get("username"));
        } catch (EmptyResultDataAccessException e) {
            Optional<User> userOpl = Optional.ofNullable(user);
            return userOpl;
        }

        Optional<User> userOpl = Optional.ofNullable(user);
        return userOpl;
    }
}
