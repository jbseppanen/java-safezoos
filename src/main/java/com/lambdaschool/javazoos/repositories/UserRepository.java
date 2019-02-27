package com.lambdaschool.javazoos.repositories;

import com.lambdaschool.javazoos.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}