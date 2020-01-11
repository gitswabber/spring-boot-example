package com.swabber.service;

import com.swabber.controller.dto.User;
import com.swabber.repository.UserEntity;
import com.swabber.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUser(int id) {
        final List<UserEntity> userEntityList = userRepository.findAll();
        final UserEntity userEntity = userRepository.getOne(id);
        return new User();
    }
}
