package com.danozzo.fullStackbackend.service;

import com.danozzo.fullStackbackend.model.User;
import com.danozzo.fullStackbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @Override
    public User saveUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public String deleteUser(Long id) {
        Optional<User> userDelete = userRepository.findById(id);
        userRepository.deleteById(userDelete.get().getId());
        return "user: " + userDelete.get().getName() + " whit id: " + id + " deleted!";
    }

}
