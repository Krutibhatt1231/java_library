package com.example.libraymanagement.librarymanagment.services;

import java.util.Optional;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.libraymanagement.librarymanagment.dto.requests.RoleRequestDto;
import com.example.libraymanagement.librarymanagment.dto.responses.RoleResponseDto;
import com.example.libraymanagement.librarymanagment.entity.Roles;
import com.example.libraymanagement.librarymanagment.repositories.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;

	public RoleResponseDto saveRoles(RoleRequestDto roles) {
		Roles role = new Roles();
		role.setId(roles.getId());
		role.setName(roles.getName());
		roleRepository.save(role);
		RoleResponseDto responseDto = new RoleResponseDto();
		responseDto.setName(role.getName());
		responseDto.setId(role.getId());
		return responseDto;
	}

	public RoleResponseDto updateRoles(RoleRequestDto roleRequestDto, Long id) {
		Optional<Roles> itemOptional = roleRepository.findById(id);
		if (itemOptional.isPresent()) {
			Roles role = itemOptional.get();

			role.setName(roleRequestDto.getName());
			roleRepository.save(role);

			RoleResponseDto roleResponseDto = new RoleResponseDto();
			roleResponseDto.setId(role.getId());
			roleResponseDto.setName(role.getName());
			return roleResponseDto;

		}
		return null;

	}
	public String deleteRoles(Long id) {
		Optional<Roles> itemOptional = roleRepository.findById(id);
		if(itemOptional.isPresent()) {
			return itemOptional.get().getName() + " is deleteted successfully";
		}
		return "something went worng";
		
	}
}
