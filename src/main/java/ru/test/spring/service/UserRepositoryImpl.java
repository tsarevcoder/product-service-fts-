package ru.test.spring.service;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import ru.test.spring.model.UserModel;
import ru.test.spring.model.UserRowMapper;
import ru.test.spring.model.dto.UserDto;
import ru.test.spring.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserRepositoryImpl implements UserRepository {

    private final JdbcClient jdbcClient;

    public UserRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public List<UserModel> findAllUsers() {
        return jdbcClient.sql("SELECT * FROM public.user_account")
                .query(new UserRowMapper())
                .list();
    }
    @Override
    public Optional<UserModel> findUserByName(String userName) {
        return jdbcClient.sql("SELECT * FROM public.user_account WHERE user_name = ?")
                .param(userName)
                .query(new UserRowMapper())
                .optional();
    }
    @Override
    public ResponseEntity<?> createUser(UserDto userDto) {
        return ResponseEntity.ok(
                jdbcClient.sql("INSERT INTO public.user_account (user_name, user_balance) VALUES (?, ?)")
                        .param(userDto.userName())
                        .param(userDto.userBalance())
                        .update()
        );
    }
}
