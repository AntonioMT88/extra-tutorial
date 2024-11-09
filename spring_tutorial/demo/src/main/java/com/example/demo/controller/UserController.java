package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<User> register(@RequestBody String username) {
        System.out.println("Registering new user with username: " + username);

        User newUser = new User(username);
        userRepository.save(newUser);

        return ResponseEntity.ok(newUser);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> getById(@PathVariable String userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<User> updateById(@PathVariable String userId, @RequestBody String username) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        user.setUsername(username);
        user = userRepository.save(user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<User> deleteById(@PathVariable String userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

}
