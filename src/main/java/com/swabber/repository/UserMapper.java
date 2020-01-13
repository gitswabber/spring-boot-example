package com.swabber.repository;

import com.swabber.controller.dto.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    List<User> userEntityListToUserList(List<UserEntity> userEntityList);
    @Mappings(@Mapping(source = "userId", target = "id"))
    User userEntityToUser(UserEntity userEntity);
    @Mappings(@Mapping(source = "id", target = "userId"))
    UserEntity userToUserEntity(User user);
}