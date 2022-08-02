package com.suleiman.RedisUsingSpringBoot.Service;

import com.suleiman.RedisUsingSpringBoot.Model.User;
import com.suleiman.RedisUsingSpringBoot.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean saveUser(User user) {
     return  userDao.saveUser(user);
    }

    @Override
    public List<User> fetchAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User fetchUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public boolean deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }
}
