package com.test.demo.controller;

import com.test.demo.entity.User;
import com.test.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserContoller {

    @Autowired
    private UserRepository userRepository;

    @PutMapping("/add")
    public User save(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        return userRepository.save(new User(name, age));
    }

    @PutMapping("/add1")
    public User add1(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/list")
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/create")
    public void create() {
        for (int i = 0; i < 20; i++) {
            User user = new User(Long.valueOf(i), "test" + i, 10 + i);
            userRepository.save(user);
        }
    }
}
