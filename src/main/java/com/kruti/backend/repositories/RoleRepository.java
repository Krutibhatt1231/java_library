package com.kruti.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kruti.backend.dto.responses.RoleResponseDto;
import com.kruti.backend.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long> {
	
	@Query("SELECT r FROM Roles r WHERE r.name = ?1")
	Roles findByName(String name);

}