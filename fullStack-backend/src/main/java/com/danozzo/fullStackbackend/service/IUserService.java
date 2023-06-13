package com.danozzo.fullStackbackend.service;

import com.danozzo.fullStackbackend.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User saveUser(User newUser);

    String deleteUser(Long id);
}
