package com.StudyBuddy.calender.Controller;

import com.StudyBuddy.calender.Entity.User;
import com.StudyBuddy.calender.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    //@RequestMapping
    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return userService.createUser(savedUser);
    }

    // READ (GET)
    @RequestMapping("/readAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping("/read/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    // UPDATE (PUT)
    @RequestMapping("/update/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // DELETE (DELETE)
    @RequestMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
