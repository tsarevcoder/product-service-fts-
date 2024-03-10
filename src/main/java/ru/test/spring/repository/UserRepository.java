package ru.test.spring.repository;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import ru.test.spring.model.UserModel;
import ru.test.spring.model.dto.UserDto;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {


    List<UserModel> findAllUsers();
    Optional<UserModel> findUserByName(String userName);


    ResponseEntity<?> createUser(UserDto userDto);
}
