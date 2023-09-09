package com.example.libraymanagement.librarymanagment.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.libraymanagement.librarymanagment.dto.requests.RoleRequestDto;
import com.example.libraymanagement.librarymanagment.dto.requests.UserRequestDto;
import com.example.libraymanagement.librarymanagment.dto.responses.RoleResponseDto;
import com.example.libraymanagement.librarymanagment.dto.responses.UserResponseDto;
import com.example.libraymanagement.librarymanagment.entity.Roles;
import com.example.libraymanagement.librarymanagment.entity.User;
import com.example.libraymanagement.librarymanagment.repositories.RoleRepository;
import com.example.libraymanagement.librarymanagment.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository rolesRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserResponseDto findUserByUserName(String userName) {
		Optional<UserResponseDto> user = userRepository.findUserByUserName(userName);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}
}


