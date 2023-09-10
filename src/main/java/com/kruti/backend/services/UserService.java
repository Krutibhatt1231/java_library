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
		// get data of user_role
		Roles roles = rolesRepository.findByName("ROLE_USER");
		// set entity data from RequestDto
		User user = new User();
		user.setFirstName(userRequestDto.getFirstName());
		user.setLastName(userRequestDto.getLastName());
		user.setUserName(userRequestDto.getUserName());
		user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
		user.setAddress(userRequestDto.getAddress());
		user.setIsEnabled(true);
		user.addRole(roles);
		userRepository.save(user);
		// prepare response
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setId(user.getId());
		userResponseDto.setFirstName(user.getFirstName());
		userResponseDto.setLastName(user.getLastName());
		userResponseDto.setUserName(user.getUserName());
		userResponseDto.setPassword(user.getPassword());
		userResponseDto.setPhoneNumber(user.getPhoneNumber());
		userResponseDto.setAddress(user.getAddress());
		userResponseDto.setEnabled(user.getIsEnabled());
		userResponseDto.setRoles(user.getRoles());
		userResponseDto.setStatus("user added successfully");
		return userResponseDto;

	}

	public UserResponseDto updateUserById(UserRequestDto userRequestDto, Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			Roles roles = rolesRepository.findByName("ROLE_USER");
			Set<Roles> roles2 = new HashSet<>();
			roles2.add(roles);
			User userItem = user.get();
			userItem.setFirstName(userRequestDto.getFirstName());
			userItem.setLastName(userRequestDto.getLastName());
			userItem.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
			userItem.setPhoneNumber(userRequestDto.getPhoneNumber());
			userItem.setIsEnabled(true);
			userItem.setRoles(roles2);
			userRepository.save(userItem);
			UserResponseDto userResponseDto = new UserResponseDto();
			userResponseDto.setId(userItem.getId());
			userResponseDto.setFirstName(userItem.getFirstName());
			userResponseDto.setLastName(userItem.getLastName());
			userResponseDto.setUserName(userItem.getUserName());
			userResponseDto.setPassword(userItem.getPassword());
			userResponseDto.setPhoneNumber(userItem.getPhoneNumber());
			userResponseDto.setAddress(userItem.getAddress());
			userResponseDto.setEnabled(userItem.getIsEnabled());
			userResponseDto.setRoles(userItem.getRoles());
			userResponseDto.setStatus("user updated successfully");
			return userResponseDto;

		}
		return null;
	}

	public String deleteUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			User userItem = user.get();
			userRepository.deleteById(id);
			return userItem.getFirstName() + " is deleted succesfully";

		}
		return "something went wrong";

	}

	public String updateUserRoleByAdmin(Long id, Long roleId) {
		Optional<User> user = userRepository.findById(id);
		Optional<Roles> roles = rolesRepository.findById(roleId);
		if (user.isPresent() && roles.isPresent()) {
			
			// check if user and role is present for roleID and userID
			User userItem = user.get();
			Roles roleItem = roles.get();
			// if its present set userRole according to role id
			Roles newRoles = new Roles();
			newRoles.setId(roleItem.getId());
			newRoles.setName(roleItem.getName());
			Set<Roles> roleSet = new HashSet<>();
			roleSet.add(newRoles);
			userItem.setRoles(roleSet);
			//save user with new role
			userRepository.save(userItem);
			return "user role updated successfully";

		}
		return "something went wrong";
	}
}
