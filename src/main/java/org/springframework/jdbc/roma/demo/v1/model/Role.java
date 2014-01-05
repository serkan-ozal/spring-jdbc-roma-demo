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

package org.springframework.jdbc.roma.demo.v1.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperField;
import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperObjectField;
import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperSpringProvider;

/**
 * @author Serkan ÖZAL
 */
public class Role {

	@RowMapperField(columnName="id")
	private Long id;
	@RowMapperField(columnName="name")
	private String name;
	@RowMapperObjectField(
			provideViaSpringProvider = 
				@RowMapperSpringProvider(
						provideCode="@{permissionDAO_v1}.getRolePermissionList(${id})"),
			lazy = true)
	private List<Permission> permissions = new ArrayList<Permission>();
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Permission> getPermissions() {
		return permissions;
	}
	
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	public void addPermission(Permission permission) {
		permissions.add(permission);
	}
	
	public void removePermission(Permission permission) {
		permissions.remove(permission);
	}
	
	@Override
	public String toString() {
		return "Name: " + name;
	}
	
}
