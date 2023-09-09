package com.kruti.backend.services;

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

import com.kruti.backend.dto.responses.UserResponseDto;
import com.kruti.backend.repositories.RoleRepository;
import com.kruti.backend.repositories.UserRepository;


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
