package com.danozzo.fullStackbackend.repository;

import com.danozzo.fullStackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
