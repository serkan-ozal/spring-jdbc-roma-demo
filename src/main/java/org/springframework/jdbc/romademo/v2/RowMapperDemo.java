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

package org.springframework.jdbc.romademo.v2;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.roma.impl.service.RowMapperService;
import org.springframework.jdbc.romademo.v2.dao.UserDAO;
import org.springframework.jdbc.romademo.v2.model.Permission;
import org.springframework.jdbc.romademo.v2.model.Role;
import org.springframework.jdbc.romademo.v2.model.User;

/**
 * @author Serkan ÖZAL
 */
public class RowMapperDemo {

	private static final Logger logger = Logger.getLogger(RowMapperDemo.class);
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("/roma-demo-context-v2.xml");
		
		// DB is initialized by DbAwareBeanPostProcessor
		
		final UserDAO userDAO = context.getBean(UserDAO.class);
		final RowMapperService rowMapperService = context.getBean(RowMapperService.class);
		
		rowMapperService.enableLazyConditionProperty("creditCardInfoLazyCondition");
		
		List<User> userList = userDAO.list();
		
		logger.info("All users have been listed from database");
		
		StringBuffer sb = new StringBuffer();
		for (User u : userList) {
			sb.append("User:\n" + "\t" + u.toString().replace("\n", "\n\t")).append("\n");
			sb.append("\tRoles            : ").append("\n");
			for (Role r : u.getRoles()) {
				sb.append("\t\t" + "Role Name: " + r.getName()).append("\n");
				for (Permission p : r.getPermissions()) {
					sb.append("\t\t\t" + "Permission Name: " + p.getName()).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
		
		rowMapperService.disableLazyConditionProperty("creditCardInfoLazyCondition");
	}

}
