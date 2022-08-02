package com.suleiman.RedisUsingSpringBoot.Service;

import com.suleiman.RedisUsingSpringBoot.Model.User;

import java.util.List;

public interface UserService {
    boolean saveUser(User user);

    List<User> fetchAllUsers();

    User fetchUserById(Long id);

    boolean deleteUserById(Long id);


}
