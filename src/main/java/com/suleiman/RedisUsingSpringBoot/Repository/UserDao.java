package com.suleiman.RedisUsingSpringBoot.Repository;

import com.suleiman.RedisUsingSpringBoot.Model.UserEntity;

import java.util.List;

public interface UserDao {
    boolean saveUser(UserEntity userEntity);

    List<UserEntity> getAllUsers();

    UserEntity getUserById(Long id);

    boolean deleteUserById(Long id);
}