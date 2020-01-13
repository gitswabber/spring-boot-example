package com.swabber.service;

import com.swabber.controller.dto.User;
import com.swabber.repository.UserEntity;
import com.swabber.repository.UserMapper;
import com.swabber.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User getUser(int id) {
        final UserEntity userEntity = userRepository.getOne(id);
        return userMapper.userEntityToUser(userEntity);
    }
}
