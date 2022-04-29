package com.jpa.practical;

import com.jpa.practical.dao.UserRepository;
import com.jpa.practical.entities.User;
import net.bytebuddy.asm.Advice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		// UserRepository userRepository = context.getBean(UserRepository.class);

		// Creating user
//		User user1 =  new User();
//		user1.setName("Susan");
//		user1.setCity("Lalitpur");
//		user1.setStatus("RN");
//		user1.setDob(LocalDate.of(1987,1,20));
//
//		User user2 =  new User();
//		user2.setName("Suman");
//		user2.setCity("Ilam");
//		user2.setStatus("Student");
//		user2.setDob(LocalDate.of(2000,1,20));
//
//		Iterable<User> resultUsers = userRepository.saveAll(List.of(user1, user2));
//		resultUsers.forEach(user -> System.out.println(user));

		// Updating user
//		Optional<User> optional = userRepository.findById(3);
//		User user = optional.get();
//		user.setName("Kamal");
//		User result = userRepository.save(user);
//		System.out.println(result);

		// Getting user
//		Optional<User> optional = userRepository.findById(3);
////		Iterable<User> users = userRepository.findAll();
////		users.forEach(user -> System.out.println(user));

		// Deleting a user




	}

}
