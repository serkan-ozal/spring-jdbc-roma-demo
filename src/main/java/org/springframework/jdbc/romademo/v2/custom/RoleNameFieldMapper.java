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

package org.springframework.jdbc.romademo.v2.custom;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperField.RowMapperFieldMapper;
import org.springframework.jdbc.romademo.v2.model.Role;

/**
 * @author Serkan ÖZAL
 */
public class RoleNameFieldMapper implements RowMapperFieldMapper<Role> {

	private static final Logger logger = Logger.getLogger(RoleNameFieldMapper.class);
	
	@Override
	public void mapField(Role role, String fieldName, ResultSet rs, int rowNum) {
		try {
			role.setName(rs.getString("name"));
		} 
		catch (SQLException e) {
			logger.error("Error occured while mapping field " + fieldName + " in Role object from resultset", e);
		}
	}

}
