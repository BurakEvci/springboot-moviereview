package com.burak.moviereview.controllers;

import com.burak.moviereview.Service.UserService;
import com.burak.moviereview.models.Movies;
import com.burak.moviereview.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;



    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Void> updateUser(@PathVariable String id, @RequestBody User user) {
        user.setId(id);
        userService.updateUser(user);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }



}
