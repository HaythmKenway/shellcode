package com.haythmKenway.shellcode.resources;

import java.util.Map;
import java.util.HashMap;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiMappings {

	@GetMapping("/api")
	public Map<String, String> getApiRoutes() {
		Map<String, String> apiRoutes = new HashMap<>();	

		apiRoutes.put("/api","Returns description of all api's");
		apiRoutes.put("/api/v1/user/register","[parameters : name email phone and password ] returns jwt token as result");
		apiRoutes.put("/api/v1/user/login","[parameters : email password ] returns jwt token as result");
		return apiRoutes;
	}
}
	