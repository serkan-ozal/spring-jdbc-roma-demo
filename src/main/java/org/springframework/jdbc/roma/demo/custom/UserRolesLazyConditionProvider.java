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

import org.apache.log4j.Logger;
import org.springframework.jdbc.roma.api.config.provider.annotation.RowMapperLazyCondition.RowMapperLazyConditionProvider;
import org.springframework.jdbc.roma.demo.model.User;

/**
 * @author Serkan ÖZAL
 */
public class UserRolesLazyConditionProvider implements RowMapperLazyConditionProvider<User> {

	private final static Logger logger = Logger.getLogger(UserRolesLazyConditionProvider.class);
	
	@Override
	public boolean evaluateCondition(User user, String fieldName, ResultSet rs, int rowNum) {
		boolean conditionResult = user.getId() % 2 == 0;
		logger.debug("Evaluated lazy condition of field " + "\"" + fieldName + "\"" +  
					 " for user with id " + "\"" + user.getId() + "\"" + " as " + "\"" + conditionResult + "\"");
		return conditionResult;
	}

}
