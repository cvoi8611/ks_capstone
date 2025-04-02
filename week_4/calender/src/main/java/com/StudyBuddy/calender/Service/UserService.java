package com.StudyBuddy.calender.Service;

import com.StudyBuddy.calender.Entity.User;
import com.StudyBuddy.calender.Entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // CREATE
    public User createUser(User user){
        return userRepository.save(user);
    }

    // READ
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id){
        return userRepository.findById(id);
    }

    // UPDATE
    public User updateUser(Integer id, User updatedUser){
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setEmail(updatedUser.getEmail());
                    user.setPassword(updatedUser.getPassword());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    // DELETE
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
}
