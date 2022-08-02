package com.suleiman.RedisUsingSpringBoot.Repository;

import com.suleiman.RedisUsingSpringBoot.Model.User;

import java.util.List;

public interface UserDao {
    boolean saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    boolean deleteUserById(Long id);
}
