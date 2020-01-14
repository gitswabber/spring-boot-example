package com.swabber.service;

import com.swabber.controller.dto.User;
import com.swabber.repository.UserEntity;
import com.swabber.repository.UserMapper;
import com.swabber.repository.UserRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private List<UserEntity> userEntityList = Lists.newArrayList();
    private List<User> userList = Lists.newArrayList();

    @BeforeEach
    void setUp() {
        userEntityList.add(new UserEntity(1, "Jaea", "Choi", 31));
        userEntityList.add(new UserEntity(2, "Suzy", "Kim", 30));
        userEntityList.add(new UserEntity(3, "Young", "Kim", 28));

        userList.add(new User(1, "Jaea", "Choi", 31));
        userList.add(new User(2, "Suzy", "Kim", 30));
        userList.add(new User(3, "Young", "Kim", 28));
    }

    @Test
    void getAllUserList() {
        when(userRepository.findAll()).thenReturn(userEntityList);
        when(userMapper.userEntityListToUserList(userEntityList)).thenReturn(userList);

        final List<User> allUserList = userService.getAllUserList();
        for (int i = 0; i < allUserList.size(); i++) {
            Assertions.assertEquals(allUserList.get(i).getId(), userEntityList.get(i).getUserId());
        }
    }

    @Test
    void getUser() {
        when(userRepository.getOne(1)).thenReturn(userEntityList.get(1));
        when(userMapper.userEntityToUser(userEntityList.get(1))).thenReturn(userList.get(1));

        final User user = userService.getUser(1);
        Assertions.assertEquals(user.getId(), userEntityList.get(1).getUserId());
    }
}