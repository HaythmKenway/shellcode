package com.haythmKenway.shellcode.services;

import javax.management.RuntimeErrorException;

import com.haythmKenway.shellcode.domain.User;
import com.haythmKenway.shellcode.exception.AuthException;

public interface userServices {

		User validateUser(String userOrEmail,String password ) throws AuthException;
		User registerUser(String name,String phone,String email,String password) throws AuthException;
		
}
