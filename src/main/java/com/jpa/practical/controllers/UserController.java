package com.jpa.practical.controllers;

import com.jpa.practical.entities.User;
import com.jpa.practical.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {
    @Autowired
    UserServices userServices;

    @GetMapping
    public List<User> getUsers() {
        return userServices.getUsers();
    }

    @GetMapping(path="{id}")
    public User getUserById(@PathVariable("id") int userId) {
        return userServices.getUserById(userId);
    }

    @PostMapping
    public void addNewUser(@RequestBody User user) {
        userServices.addNewUser(user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") int userId) {
        userServices.deleteUser(userId);
    }

    @PostMapping(path="{id}")
    public void updateUser(@PathVariable("id") int userId,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String city,
                           @RequestParam(required = false) String status,
                           @RequestParam(required = false) LocalDate dob,
                           @RequestParam(required = false) String email) {
        userServices.updateUser(userId, name, city, status, dob, email);
    }

    // Custom query implementations
    @GetMapping(path="/name/{name}")
    public void findByName(@PathVariable("name") String name) {
        userServices.findByName(name);
    }
}
