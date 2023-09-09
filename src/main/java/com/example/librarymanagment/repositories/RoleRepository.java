package com.example.libraymanagement.librarymanagment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.libraymanagement.librarymanagment.dto.responses.RoleResponseDto;
import com.example.libraymanagement.librarymanagment.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long>{

	RoleResponseDto findByName(String name);


}
