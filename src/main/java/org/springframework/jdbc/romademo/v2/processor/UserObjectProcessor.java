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

package org.springframework.jdbc.romademo.v2.processor;

import java.sql.ResultSet;
import java.util.Calendar;

import org.springframework.jdbc.roma.api.processor.RowMapperObjectProcessor;
import org.springframework.jdbc.romademo.v2.model.User;

/**
 * @author Serkan ÖZAL
 */
public class UserObjectProcessor implements RowMapperObjectProcessor<User> {

	@SuppressWarnings("deprecation")
	@Override
	public void processObject(User user, ResultSet rs, int rowNum) {
		if (user.getBirthDate() != null) {
			user.setAge((byte)(Calendar.getInstance().getTime().getYear() - user.getBirthDate().getYear()));
		}
	}

}
