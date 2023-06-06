package com.haythmKenway.shellcode.resources;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haythmKenway.shellcode.Constants;
import com.haythmKenway.shellcode.domain.User;
import com.haythmKenway.shellcode.services.userServices;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("api/v1/user")
public class userResources {
	@Autowired
	userServices userService;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String,String>> loginUser(@RequestBody Map<String, Object> userMap){
	
		String email=(String) userMap.get("email");
		String password=(String) userMap.get("password");
		User user =userService.validateUser(email, password);
		return new ResponseEntity<>(generateJWTToken(user),HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<Map<String,String>> registerUser(@RequestBody Map<String, Object> userMap) {

		String name=(String) userMap.get("name");
		String email=(String) userMap.get("email");
		String phone=(String )userMap.get("phone");
		String password=(String) userMap.get("password");

		User user=userService.registerUser(name,phone, email, password);
		return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
	}
	
	private Map<String,String> generateJWTToken(User user){
	    long timestamp =System.currentTimeMillis();
	    @SuppressWarnings("deprecation")
		String token= Jwts.builder().signWith(SignatureAlgorithm.HS256,Constants.API_SECRET_KEY)
	            .setIssuedAt(new Date(timestamp)).setExpiration(new Date(timestamp+Constants.TOKEN_VALIDITY))
	            .claim("userId", user.getUserId()).claim("email", user.getEmail())
	            .claim("name",user.getName()).claim("phone",user.getPhone())
	            .compact();
	    Map<String,String> tokenMap= new HashMap<>();
	    tokenMap.put("token", token);
	    return tokenMap;
	}

	
}
