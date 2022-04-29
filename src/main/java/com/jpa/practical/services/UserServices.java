package com.jpa.practical.services;

import com.jpa.practical.dao.UserRepository;
import com.jpa.practical.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServices {
    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int userId) {
        Optional<User> optional = userRepository.findById(userId);
        if(!optional.isPresent()) {
            throw new IllegalStateException("User with id" + userId + " does not exist!");
        }
        return optional.get();
    }

    public void addNewUser(User user) {
        Optional<User> optional = userRepository.findUserByEmail(user.getEmail());
        if(optional.isPresent()) {
            throw new IllegalStateException("User with email: " + user.getEmail() + " already exists!");
        }
        userRepository.save(user);
    }

    public void deleteUser(int userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists) {
            throw new IllegalStateException("User with Id "+ userId + " already exists!");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(int userId, String name, String city, String status, LocalDate dob, String email) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalStateException("User with Id "+userId+" does not exist!"));
        if(name != null && name.length() > 0 && !Objects.equals(user.getName(), name)) {
            user.setName(name);
        }

        if(city != null && city.length() > 0 && !Objects.equals(user.getCity(), city)) {
            user.setCity(city);
        }

        if(status != null && status.length() > 0 && !Objects.equals(user.getStatus(), status)) {
            user.setStatus(status);
        }

        if(dob != null && !Objects.equals(user.getDob(), dob)) {
            user.setDob(dob);
        }

        if(email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)) {
            Optional<User> optional = userRepository.findUserByEmail(email);
            if(optional.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            user.setEmail(email);
        }
    }
}
