package com.springproject.userdept.Controllers;

import com.springproject.userdept.Entities.User;
import com.springproject.userdept.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> findAll() {

        List<User> result = userRepository.findAll();

        if(result.isEmpty()) {
            throw new RuntimeException("No users found");
        }

        return result;
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {

        User result = userRepository.findById(id).get();

        if(result == null) {
            throw new RuntimeException("No user found with id: " + id);
        }

        return result;
    }

    @PostMapping
    public User insert(@RequestBody User user) {

        User result = userRepository.save(user);

        if(result == null) {
            throw new RuntimeException("Error inserting user");
        }

        return result;
    }

}
