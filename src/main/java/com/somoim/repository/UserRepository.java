package com.somoim.repository;

import com.somoim.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(String userId);

    Optional<User> findByEmail(String email);
}
