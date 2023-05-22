package com.haythmKenway.shellcode.services;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haythmKenway.shellcode.domain.User;
import com.haythmKenway.shellcode.exception.AuthException;
import com.haythmKenway.shellcode.repositories.UserRepositories;

@Service
@Transactional
public class UserServiceImplementaition implements userServices {

    @Autowired
    UserRepositories userRepository;

    @Override
    public User validateUser(String email, String password) throws AuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email.toLowerCase() != null) {
            if (pattern.matcher(email).matches()) {
                return userRepository.findByEmailAndPassword(email, password);
            } else {
                
            	throw new AuthException("Invalid email format");
            }
        }
        throw new AuthException("User or email is null");
    }

    @Override
    public User registerUser(String name, String phone, String email, String password) throws AuthException {
        Pattern emailpattern = Pattern.compile("^(.+)@(.+)$");
        Pattern phonePattern= Pattern.compile("^\\d{10}$");
        if (email.toLowerCase() != null) {
            if (!emailpattern.matcher(email).matches()) {
       
                throw new AuthException("Invalid email format");
            }
            else if(!phonePattern.matcher(phone).matches()) {
            	throw new AuthException("Invalid mobile format");
            }
        }
        if (userRepository.getCountByEmail(email) > 0) {
            throw new AuthException("Email already in use");
        }

        Integer userId = userRepository.create(name, phone, email, password);
        return userRepository.findById(userId);
    }
}
