package com.suleiman.RedisUsingSpringBoot.Controller;

import com.suleiman.RedisUsingSpringBoot.Model.UserEntity;
import com.suleiman.RedisUsingSpringBoot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("redis/api/")
public class UserController {

    @Autowired
    private   UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody UserEntity userEntity) {
        boolean result = userService.saveUser(userEntity);
        if(result) {
            return ResponseEntity.ok("The user user has been created Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUser() {
        List<UserEntity> userEntities;
        userEntities = userService.fetchAllUsers();
        return ResponseEntity.ok(userEntities);
    }

    @GetMapping("/{id}")
    public UserEntity fetchUserById(@PathVariable("id") Long id) {
        UserEntity user = userService.fetchUserById(id);
        return user;
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        boolean result = userService.deleteUserById(id);
        if(result) {
            return ResponseEntity.ok("User has successfully been deleted");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }


    }

}