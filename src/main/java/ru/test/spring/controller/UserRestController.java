package ru.test.spring.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.spring.expection.UserNotFoundException;
import ru.test.spring.model.UserModel;
import ru.test.spring.model.dto.UserDto;
import ru.test.spring.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserRestController {

    private final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> findAllUsers() {
        return ResponseEntity.ok(userRepository.findAllUsers());
    }


    @GetMapping("/user/{userName}")
    public ResponseEntity<UserModel> findUserByName(@PathVariable String userName) {
        return ResponseEntity.ok(userRepository.findUserByName(userName).orElseThrow(UserNotFoundException::new));
    }


    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userRepository.createUser(userDto));
    }
}
