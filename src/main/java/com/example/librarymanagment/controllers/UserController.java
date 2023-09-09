package com.example.libraymanagement.librarymanagment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraymanagement.librarymanagment.dto.requests.RoleRequestDto;
import com.example.libraymanagement.librarymanagment.dto.requests.UserRequestDto;
import com.example.libraymanagement.librarymanagment.dto.responses.RoleResponseDto;
import com.example.libraymanagement.librarymanagment.dto.responses.UserResponseDto;
import com.example.libraymanagement.librarymanagment.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;



}
