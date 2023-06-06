package com.haythmKenway.shellcode.repositories;

import com.haythmKenway.shellcode.domain.User;
import com.haythmKenway.shellcode.exception.AuthException;

public interface UserRepositories {

	Integer create(String name,String phone,String email,String password) throws AuthException;
	User findByEmailAndPassword(String email,String password) throws AuthException;
	Integer getCountByEmail(String email);
	User findById(Integer userId);
	Integer findIdByEmail(String email);
}
