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

import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperObjectField;
import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperSqlProvider;

/**
 * @author Serkan ÖZAL
 */
public class Role {

	private Long id;
	private String name;
	@RowMapperObjectField(
	        provideViaSqlProvider = 
	            @RowMapperSqlProvider(
	                provideSql = 
	                    "SELECT p.* FROM PERMISSION p WHERE p.ID IN " +
	                    "(" +
	                        "SELECT rp.PERMISSION_ID FROM role_permission rp WHERE rp.ROLE_ID = ${id}" +
	                    ") ORDER BY p.name"),
	        fieldType = Permission.class,		    
	        lazy = true)
	private List<Permission> permissions;
	
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
