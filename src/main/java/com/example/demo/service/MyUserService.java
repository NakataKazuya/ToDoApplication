package com.example.demo.service;

import com.example.demo.entity.MyUserDetails;
import com.example.demo.entity.User;
import com.example.demo.repository.IUserAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserService implements UserDetailsService {

    public final IUserAccountDao dao;

    @Autowired
    public MyUserService(IUserAccountDao dao) {
        this.dao = dao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = dao.findUser(username);
        if(!user.isPresent()) {
            throw new UsernameNotFoundException(username + "が存在しません");
        }
        return new MyUserDetails(user.get());
    }
}
