package com.swabber.repository;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@Slf4j
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        List<UserEntity> userEntityList = Lists.newArrayList();
        userEntityList.add(new UserEntity().setFirstName("Jaea").setLastName("Choi").setAge(31));
        userEntityList.add(new UserEntity().setFirstName("Suzy").setLastName("Kim").setAge(30));
        userEntityList.add(new UserEntity().setFirstName("Young").setLastName("Kim").setAge(28));
        userRepository.saveAll(userEntityList);
    }

    @Test
    void findAll() {
        final List<UserEntity> userEntityList = userRepository.findAll();
        userEntityList.forEach(userEntity -> log.info("User name : " + userEntity.getLastName() + " " + userEntity.getFirstName() + ", age : " + userEntity.getAge()));
        Assertions.assertEquals(userEntityList.size(), 3);
    }

    @Test
    void findById() {
        final UserEntity firstUserEntity = userRepository.findAll().get(0);
        final Optional<UserEntity> userEntityOptional = userRepository.findById(firstUserEntity.getUserId());
        Assertions.assertEquals(userEntityOptional.isPresent(), true);
        final UserEntity userEntity = userEntityOptional.get();
        log.info("User name : " + userEntity.getLastName() + " " + userEntity.getFirstName() + ", age : " + userEntity.getAge());
    }

    @Test
    void update() {
        final UserEntity firstUserEntity = userRepository.findAll().get(0);
        final UserEntity userEntity = userRepository.findById(firstUserEntity.getUserId()).get();
        userEntity.setFirstName("Lee");
        final UserEntity updatedUserEntity = userRepository.save(userEntity);
        Assertions.assertEquals(updatedUserEntity.getFirstName(), "Lee");
    }

    @Test
    void delete() {
        final UserEntity firstUserEntity = userRepository.findAll().get(0);
        userRepository.deleteById(firstUserEntity.getUserId());
        Assertions.assertEquals(userRepository.findAll().size(), 2);
    }
}