package com.suleiman.RedisUsingSpringBoot.Controller;

import com.suleiman.RedisUsingSpringBoot.Model.User;
import com.suleiman.RedisUsingSpringBoot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("redis/api/")
public class UserController {

    @Autowired
  private   UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        boolean result = userService.saveUser(user);
        if(result) {
            return ResponseEntity.ok("The user user has been created Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users;
        users = userService.fetchAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> fetchUserById(@PathVariable("id") Long id) {
        User user = userService.fetchUserById(id);
        return ResponseEntity.ok(user);
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
