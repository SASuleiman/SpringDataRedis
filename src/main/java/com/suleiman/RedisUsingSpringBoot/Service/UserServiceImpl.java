package com.suleiman.RedisUsingSpringBoot.Service;

import com.suleiman.RedisUsingSpringBoot.Model.UserEntity;
import com.suleiman.RedisUsingSpringBoot.Repository.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class.getName());
    @Autowired
    private UserDao userDao;

    @Override
    public boolean saveUser(UserEntity userEntity) {
        return  userDao.saveUser(userEntity);
    }

    @Override
    public List<UserEntity> fetchAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public UserEntity fetchUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public boolean deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }
}
