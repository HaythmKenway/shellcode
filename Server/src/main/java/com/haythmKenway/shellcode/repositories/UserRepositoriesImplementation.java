package com.haythmKenway.shellcode.repositories;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.haythmKenway.shellcode.domain.User;
import com.haythmKenway.shellcode.exception.AuthException;

@Repository
public class UserRepositoriesImplementation implements UserRepositories {
    private static final String SQL_CREATE = "INSERT INTO users(name, phone, email, password) VALUES(?, ?, ?, ?)";
    private static final String SQL_COUNT_BY_EMAIL = "SELECT COUNT(*) FROM users WHERE email = ?";
    private static final String SQL_FIND_BY_USERID = "SELECT user_id, name, email, phone, password FROM users WHERE user_id = ?";
    private static final String SQL_FIND_ID_BY_EMAIL = "SELECT user_id FROM users WHERE email = ?";
    private static final String SQL_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer create(String name, String phone, String email, String plainPassword) throws AuthException {
        try {
            String password = BCrypt.hashpw(plainPassword, BCrypt.gensalt(10));
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, name);
                ps.setString(2, phone);
                ps.setString(3, email);
                ps.setString(4, password);
                return ps;
            });
            return findIdByEmail(email);
        } catch (Exception e) {
            throw new AuthException("Invalid details, failed to create account");
        }
    }

    @SuppressWarnings({ "unused", "deprecation" })
    public User findByEmailAndPassword(String email, String password) throws AuthException {
	    try {
	        User user = jdbcTemplate.queryForObject(SQL_USER_BY_EMAIL, new Object[]{email}, userRowMapper);
	        System.out.println(password);
	        System.out.println(user.getPassword());
	        if (!BCrypt.checkpw(password, user.getPassword()))
	            throw new AuthException("Invalid Email/password");
	        return user;
	    } catch (EmptyResultDataAccessException e) {
	        throw new AuthException("Invalid Email/password");
	    }
	}


    @SuppressWarnings("deprecation")
    @Override
    public Integer getCountByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL, new Object[] { email }, Integer.class);
    }

    public User findById(Integer userId) {
        Map<String, Object> result = jdbcTemplate.queryForMap(SQL_FIND_BY_USERID, new Object[] { userId });
        if (result == null) {
            return null;
        }
        return new User((Integer) result.get("user_id"), (String) result.get("name"), (String) result.get("phone"),
                (String) result.get("email"), (String) result.get("password"));
    }

    @Override
    public Integer findIdByEmail(String email) {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_ID_BY_EMAIL, new Object[] { email }, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private RowMapper<User> userRowMapper = ((rs, rowNum) -> {
        return new User(rs.getInt("user_id"), rs.getString("name"), rs.getString("phone"), rs.getString("email"),
                rs.getString("password"));
    });
}
