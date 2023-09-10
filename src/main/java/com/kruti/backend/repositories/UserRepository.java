package com.kruti.backend.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kruti.backend.dto.responses.UserResponseDto;
import com.kruti.backend.entity.Roles;
import com.kruti.backend.entity.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<UserResponseDto> findUserByUserName(String userName);

	@Query(value = "DELETE u FROM users u WHERE u.id =id", nativeQuery = true)
	String deleteUserById(Long id);

//	@Modifying
//	@Transactional
//	@Query(value = "UPDATE   users_role u  SET u.role_id=:roleId WHERE u.user_id=:id")
//	public void updateUserRoleByAdmin(Long userId, Long roleId);

}
