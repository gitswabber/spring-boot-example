package com.swabber.repository;

import com.swabber.controller.dto.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    private UserEntity userEntity = new UserEntity();

    @BeforeEach
    void setUp() {
        userEntity.setUserId(11);
        userEntity.setFirstName("testFirstName");
        userEntity.setLastName("testLastName");
        userEntity.setAge(22);
    }

    @Test
    void userEntityToUser() {
        final User user = userMapper.userEntityToUser(userEntity);

        Assertions.assertEquals(user.getFirstName(), userEntity.getFirstName());
        Assertions.assertEquals(user.getLastName(), userEntity.getLastName());
        Assertions.assertEquals(user.getAge(), userEntity.getAge());
    }
}