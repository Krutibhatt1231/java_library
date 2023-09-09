package com.kruti.backend.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kruti.backend.dto.responses.UserResponseDto;
import com.kruti.backend.entity.Roles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class UserInfoUserDetails implements UserDetails {

	/**
	 * 
	 */
	//why to add this?
	private static final long serialVersionUID = 1L;
	Long id;
	String firstName;
	String lastName;
	String userName;
	String address;
	String phoneNumber;
	String password;
	boolean isEnabled;
	List<SimpleGrantedAuthority> authorities = new ArrayList<>();

	public UserInfoUserDetails(UserResponseDto user) {
		id = user.getId();
		firstName = user.getFirstName();
		lastName = user.getLastName();
		userName = user.getUserName();
		address = user.getAddress();
		phoneNumber = user.getAddress();
		password = user.getPassword();
		isEnabled = user.isEnabled();
		password = user.getPassword();
		Set<Roles> roles = user.getRoles();
		for (Roles role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}