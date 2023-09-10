package com.kruti.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kruti.backend.dto.requests.AssignRoleToUserByAdminRequest;
import com.kruti.backend.dto.requests.UserRequestDto;
import com.kruti.backend.dto.responses.UserResponseDto;
import com.kruti.backend.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserResponseDto> addDefaultUser(@RequestBody UserRequestDto userRequestDto) {
		return ResponseEntity.ok().body(userService.addUser(userRequestDto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserResponseDto> updateUserById(@RequestBody UserRequestDto userRequestDto,
			@PathVariable Long id) {
		return ResponseEntity.ok().body(userService.updateUserById(userRequestDto, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
		return ResponseEntity.ok().body(userService.deleteUserById(id));
	}
	
	@PostMapping("/updateRoleByAdmin/{id}")
	public ResponseEntity<String> updateUserRoleByAdmin(@PathVariable Long id,@RequestBody AssignRoleToUserByAdminRequest request){
		return ResponseEntity.ok().body(userService.updateUserRoleByAdmin(id,request.getRoleId()));
		
	}

}