package com.kruti.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kruti.backend.dto.responses.RoleResponseDto;
import com.kruti.backend.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long>{

	RoleResponseDto findByName(String name);


}