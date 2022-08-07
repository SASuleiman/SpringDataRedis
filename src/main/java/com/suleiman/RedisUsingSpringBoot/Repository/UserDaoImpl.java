package com.suleiman.RedisUsingSpringBoot.Repository;

import com.suleiman.RedisUsingSpringBoot.Model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class UserDaoImpl implements UserDao {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "UserEntity";

    @Override
    public boolean saveUser(UserEntity userEntity) {
        try {
            redisTemplate.opsForHash().put(KEY, userEntity.getId(), userEntity);
            return true;
        } catch (Exception e ) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> userEntities;
        userEntities = redisTemplate.opsForHash().values(KEY);
        return userEntities;
    }

    @Override
    public UserEntity getUserById(Long id) {
        UserEntity userEntity = (UserEntity) redisTemplate.opsForHash().get(KEY,id);
        return userEntity;
    }

    @Override
    public boolean deleteUserById(Long id) {
        try {
            redisTemplate.opsForHash().delete(KEY,id);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
