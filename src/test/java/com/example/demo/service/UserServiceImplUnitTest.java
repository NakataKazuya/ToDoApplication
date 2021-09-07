package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@DisplayName("UserServiceImplの単体テスト")
class UserServiceImplUnitTest {

    @Mock
    private UserDao dao;

    @InjectMocks
    private  UserServiceImpl userServiceImpl;

    @Test
    @DisplayName("userテーブルに1件挿入する")
    void testInsertUserData() {

        User user = new User();
        user.setUsername("テスト");
        user.setEmail("test@example.com");
        user.setPassword("hogehoge");
        user.setEnabled(true);
        user.setAuthority("USER");
        when(dao.insert(user)).thenReturn(1);

        dao.insert(user);

        verify(dao,times(1)).insert(user);
        assertEquals(1, dao.insert(user));
    }
}
