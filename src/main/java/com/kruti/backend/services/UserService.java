package com.kruti.backend.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kruti.backend.dto.requests.RoleRequestDto;
import com.kruti.backend.dto.requests.UserRequestDto;
import com.kruti.backend.dto.responses.RoleResponseDto;
import com.kruti.backend.dto.responses.UserResponseDto;
import com.kruti.backend.entity.Roles;
import com.kruti.backend.entity.User;
import com.kruti.backend.repositories.RoleRepository;
import com.kruti.backend.repositories.UserRepository;

import jakarta.persistence.Column;

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
	

	public UserResponseDto addUser(UserRequestDto userRequestDto) {
		Roles roles = rolesRepository.findByName("ROLE_USER");
	
		System.out.println("user role :"+roles.getName());
	
		User user = new User();
		user.setFirstName(userRequestDto.getFirstName());
		user.setLastName(userRequestDto.getLastName());
		user.setUserName(userRequestDto.getUserName());
		user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
		user.setAddress(userRequestDto.getAddress());
		user.setIsEnabled(true);
		user.addRole(roles);
		userRepository.save(user);
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setId(user.getId());
		userResponseDto.setFirstName(user.getFirstName());
		userResponseDto.setLastName(user.getLastName());
		userResponseDto.setUserName(user.getUserName());
		userResponseDto.setAddress(user.getAddress());
		userResponseDto.setEnabled(user.getIsEnabled());
		userResponseDto.setRoles(user.getRoles());
		userResponseDto.setStatus("user added successfully");
		return userResponseDto;

	}
}
