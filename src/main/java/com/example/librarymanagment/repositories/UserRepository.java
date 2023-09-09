package com.example.libraymanagement.librarymanagment.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.libraymanagement.librarymanagment.dto.responses.UserResponseDto;
import com.example.libraymanagement.librarymanagment.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	Optional<UserResponseDto> findUserByUserName(String userName);


}
