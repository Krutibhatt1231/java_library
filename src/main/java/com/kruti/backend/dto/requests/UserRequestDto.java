package com.kruti.backend.dto.requests;

import java.util.Set;

public class UserRequestDto {
	Long id;
	String firstName;
	String lastName;
	String userName;
	String address;
	String phoneNumber;
	String password;
	Boolean isEnabled; 
	//private Set<RoleRequestDto> roles;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
//	public Set<RoleRequestDto> getRoles() {
//		return roles;
//	}
//	public void setRoles(Set<RoleRequestDto> roles) {
//		this.roles = roles;
//	}
//	  public void addRole(RoleRequestDto role) {
//	        this.roles.add(role);
//	
//	  }	

}
