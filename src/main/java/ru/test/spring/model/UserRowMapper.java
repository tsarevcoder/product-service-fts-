package ru.test.spring.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserModel(rs.getLong("id"), rs.getString("user_name"), rs.getInt("user_balance"));
    }
}
