package com.kruti.backend.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kruti.backend.dto.requests.UserRequestDto;
import com.kruti.backend.dto.responses.UserResponseDto;
import com.kruti.backend.services.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserResponseDto> addDefaultUser(@RequestBody UserRequestDto userRequestDto){
		return ResponseEntity.ok().body(userService.addUser(userRequestDto));
	}



}