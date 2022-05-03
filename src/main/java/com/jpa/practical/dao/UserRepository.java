package com.jpa.practical.dao;

import com.jpa.practical.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);
    List<User> findByName(String name);
    List<User> findByNameAndCity(String name, String city);
    List<Integer> ages = List.of(1,2,3);
    List<User> findByAgeIn(List<Integer> ages);
}
