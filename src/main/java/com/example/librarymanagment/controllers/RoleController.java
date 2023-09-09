package com.example.libraymanagement.librarymanagment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.libraymanagement.librarymanagment.dto.requests.RoleRequestDto;
import com.example.libraymanagement.librarymanagment.dto.responses.RoleResponseDto;
import com.example.libraymanagement.librarymanagment.services.RoleService;

@RestController
//@RequestMapping("/admin/roles")
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@PostMapping
	ResponseEntity<RoleResponseDto> saveRoles(@RequestBody RoleRequestDto roleRequestDto) {
		return ResponseEntity.ok().body(roleService.saveRoles(roleRequestDto));
	}
	@PutMapping("/{id}")
	ResponseEntity<RoleResponseDto> updateRoles(@RequestBody RoleRequestDto roleRequestDto,@PathVariable Long id){
		return ResponseEntity.ok().body(roleService.updateRoles(roleRequestDto, id));
	}
	@DeleteMapping("/{id}")
	ResponseEntity<String> deleteRoles(@PathVariable Long id){
		return ResponseEntity.ok().body(roleService.deleteRoles(id));
	}
	
}
 