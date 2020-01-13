package com.swabber.service;

import com.swabber.controller.dto.User;
import com.swabber.repository.UserEntity;
import com.swabber.repository.UserMapper;
import com.swabber.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<User> getAllUserList() {
        final List<UserEntity> userEntityList = userRepository.findAll();
        return userMapper.userEntityListToUserList(userEntityList);
    }

    public User getUser(int id) {
        final UserEntity userEntity = userRepository.getOne(id);
        return userMapper.userEntityToUser(userEntity);
    }

    public void createUser(User user) {
        final UserEntity userEntity = userMapper.userToUserEntity(user);
        userRepository.save(userEntity);
    }

    public void updateUser(int id, User user) {
        userRepository.findById(id).orElseThrow();
        final UserEntity updatedUserEntity = userMapper.userToUserEntity(user);
        userRepository.save(updatedUserEntity);
    }

    public void updatedUserAge(int id, int age) {
        final UserEntity updatedUserEntity = userRepository.findById(id).orElseThrow();
        updatedUserEntity.setAge(age);
        userRepository.save(updatedUserEntity);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
