package com.burak.moviereview.repository;

import com.burak.moviereview.dto.UserDto;
import com.burak.moviereview.models.Movies;
import com.burak.moviereview.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
    Optional<User> findUserById(String id);
    Optional<User> getUserById(String id);

}
