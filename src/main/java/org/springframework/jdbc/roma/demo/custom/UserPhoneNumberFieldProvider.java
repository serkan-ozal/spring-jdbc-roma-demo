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

package org.springframework.jdbc.roma.demo.custom;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperCustomProvider.RowMapperFieldProvider;
import org.springframework.jdbc.roma.demo.model.User;

/**
 * @author Serkan ÖZAL
 */
public class UserPhoneNumberFieldProvider implements RowMapperFieldProvider<User, String> {

	private final static Logger logger = Logger.getLogger(UserPhoneNumberFieldProvider.class);
	
	@Override
	public String provideField(User user, String fieldName, ResultSet rs, int rowNum) {
		try {
			return rs.getString("phone_number");
		} 
		catch (SQLException e) {
			logger.error("Error occured while mapping field " + fieldName + " in User object from resultset", e);
			return null;
		}
	}

}
