package com.suleiman.RedisUsingSpringBoot.Service;

import com.suleiman.RedisUsingSpringBoot.Model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean saveUser(UserEntity userEntity);

    List<UserEntity> fetchAllUsers();

    UserEntity fetchUserById(Long id);

    boolean deleteUserById(Long id);


}
