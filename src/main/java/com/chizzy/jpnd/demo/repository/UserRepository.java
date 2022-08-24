package com.chizzy.jpnd.demo.repository;

import com.chizzy.jpnd.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}