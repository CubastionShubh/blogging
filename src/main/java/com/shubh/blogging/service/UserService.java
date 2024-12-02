package com.shubh.blogging.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shubh.blogging.model.User;
import com.shubh.blogging.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user Not Found"));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(Long id, UserDto userDto){
        User user = getUserById(id);
        user.setUserName(userDto.getUserName());
        return userRepository.save(user);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
