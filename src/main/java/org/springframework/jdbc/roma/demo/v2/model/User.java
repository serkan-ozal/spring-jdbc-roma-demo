/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.jdbc.roma.demo.v2.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperObjectField;
import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperSpringProvider;
import org.springframework.jdbc.roma.demo.common.model.Gender;

/**
 * @author Serkan ÖZAL
 */
public class User {

	private Long id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private boolean enabled = true;
	private Gender gender;
	@RowMapperObjectField(
			provideViaSpringProvider = 
				@RowMapperSpringProvider(
						provideCode="@{roleDAO_v2}.getUserRoleList(${id})"),
			lazy = true)
	private List<Role> roles = new ArrayList<Role>();
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role) {
		roles.add(role);
	}
	
	public void removeRole(Role role) {
		roles.remove(role);
	}
	
	@Override
	public String toString() {
		return 
				"Username   : " + username 	+ "\n" +
				"Password   : " + password 	+ "\n" +
				"First Name : " + firstname + "\n" +
				"Last Name  : " + lastname 	+ "\n" +
				"Enabled    : " + enabled;
	}
	
}
