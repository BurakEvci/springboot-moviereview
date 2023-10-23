package com.burak.moviereview.Service;

import com.burak.moviereview.models.Movies;
import com.burak.moviereview.models.User;
import com.burak.moviereview.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {

        return userRepository.findAll();
    }


    public Optional<User> getUserById(String id) {

        return userRepository.findUserById(id);
    }


    public Optional<User> getUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }


    public void createUser(User user) {
        Optional<User> userOptional = userRepository
                .findUserById(user.getId());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("user could not created");
        }
        userRepository.save(user);
    }



    public void updateUser(User user) {

        userRepository.save(user);
    }


    public void deleteUser(String id) {

        userRepository.deleteById(id);
    }




}
