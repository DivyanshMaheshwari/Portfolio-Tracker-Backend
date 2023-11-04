package com.example.portfoliotracker.portfoliotracker.controller;

import com.example.portfoliotracker.portfoliotracker.entity.User;
import com.example.portfoliotracker.portfoliotracker.generateUniqueNumber;
import com.example.portfoliotracker.portfoliotracker.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/portfolio")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private generateUniqueNumber gun;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Check if the email is already registered
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User is already registered");
        }

        // Generate a unique folio number
        int folioNumber;
        do {
            folioNumber = gun.generateUniqueNumber();
        } while (gun.folioNumberExists(folioNumber));
        user.setId(folioNumber);

        // Hash the password and save the user
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null && BCrypt.checkpw(user.getPassword(), existingUser.getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body("Login successful");
        }
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User is not registered. Please register the user first");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
