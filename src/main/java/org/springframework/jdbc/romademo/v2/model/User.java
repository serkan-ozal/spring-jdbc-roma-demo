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

package org.springframework.jdbc.romademo.v2.model;

import java.util.List;

import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperEnumField;
import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperObjectField;
import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperSpringProvider;
import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperEnumField.RowMapperEnumAutoMapper;
import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperEnumField.RowMapperEnumNumericValueNumericMapping;
import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperEnumField.RowMapperEnumNumericValueStringMapping;
import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperEnumField.RowMapperEnumNumericMapper;
import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperEnumField.RowMapperEnumStringMapper;
import org.springframework.jdbc.romademo.common.model.BloodType;
import org.springframework.jdbc.romademo.common.model.Education;
import org.springframework.jdbc.romademo.common.model.Gender;
import org.springframework.jdbc.romademo.common.model.Language;
import org.springframework.jdbc.romademo.common.model.MaritalStatus;
import org.springframework.jdbc.romademo.common.model.Occupation;
import org.springframework.jdbc.romademo.v2.mapper.BloodTypeEnumMapper;
import org.springframework.jdbc.romademo.v2.mapper.MaritalStatusEnumMapper;

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
	@RowMapperEnumField(enumStartValue = 1)
	private Language language;
	@RowMapperEnumField(
			mapViaAutoMapper = 
				@RowMapperEnumAutoMapper(
						mapViaNumericValueNumericMappings = {
								@RowMapperEnumNumericValueNumericMapping(mappingIndex = 0 , value = 0),
								@RowMapperEnumNumericValueNumericMapping(mappingIndex = 1 , value = 100),
								@RowMapperEnumNumericValueNumericMapping(mappingIndex = 2 , value = 200),
								@RowMapperEnumNumericValueNumericMapping(mappingIndex = 3 , value = 300),
								@RowMapperEnumNumericValueNumericMapping(mappingIndex = 4 , value = 400),
								@RowMapperEnumNumericValueNumericMapping(mappingIndex = 5 , value = 500),
								@RowMapperEnumNumericValueNumericMapping(mappingIndex = 6 , value = 600),
								@RowMapperEnumNumericValueNumericMapping(mappingIndex = 7 , value = 700)
						}))
	private Occupation occupation;
	@RowMapperEnumField(
			mapViaAutoMapper = 
				@RowMapperEnumAutoMapper(
						mapViaNumericValueStringMappings = {
								@RowMapperEnumNumericValueStringMapping(mappingValue = "PRIMARY_SCHOOL" , value = 1),
								@RowMapperEnumNumericValueStringMapping(mappingValue = "SECONDARY_SCHOOL" , value = 2),
								@RowMapperEnumNumericValueStringMapping(mappingValue = "HIGH_SCHOOL" , value = 3),
								@RowMapperEnumNumericValueStringMapping(mappingValue = "BACHELOR" , value = 4),
								@RowMapperEnumNumericValueStringMapping(mappingValue = "MASTER" , value = 5),
								@RowMapperEnumNumericValueStringMapping(mappingValue = "PHD" , value = 6),
								@RowMapperEnumNumericValueStringMapping(mappingValue = "ASSOCIATE_PROFESSOR" , value = 7),
								@RowMapperEnumNumericValueStringMapping(mappingValue = "PROFESSOR" , value = 8),
								@RowMapperEnumNumericValueStringMapping(mappingValue = "OTHER" , value = 9)
						}))
	private Education education;
	@RowMapperEnumField(
			mapViaNumericMapper = 
				@RowMapperEnumNumericMapper(
							mapper = BloodTypeEnumMapper.class))
	private BloodType bloodType;
	@RowMapperEnumField(
			mapViaStringMapper = 
				@RowMapperEnumStringMapper(
							mapper = MaritalStatusEnumMapper.class))
	private MaritalStatus maritalStatus;
	@RowMapperObjectField(
			provideViaSpringProvider = 
				@RowMapperSpringProvider(
						provideCode="@{roleDAO_v2}.getUserRoleList(${id})"),
			fieldType = Role.class,			
			lazy = true)
	private List<Role> roles;
	
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
	
	public Language getLanguage() {
		return language;
	}
	
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public Occupation getOccupation() {
		return occupation;
	}
	
	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}
	
	public Education getEducation() {
		return education;
	}
	
	public void setEducation(Education education) {
		this.education = education;
	}
	
	public BloodType getBloodType() {
		return bloodType;
	}
	
	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}
	
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}
	
	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
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
				"Username       : " + username 			+ "\n" +
				"Password       : " + password 			+ "\n" +
				"First Name     : " + firstname 		+ "\n" +
				"Last Name      : " + lastname 			+ "\n" +
				"Enabled        : " + enabled 			+ "\n" +
				"Gender         : " + gender 			+ "\n" +
				"Language       : " + language 			+ "\n" +
				"Occupation     : " + occupation 		+ "\n" +
				"Education      : " + education 		+ "\n" +
				"Blood Type     : " + bloodType			+ "\n" +
				"Marital Status : " + maritalStatus;
	}
	
}
