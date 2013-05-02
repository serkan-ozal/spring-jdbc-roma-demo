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

package org.springframework.jdbc.roma.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.roma.demo.dao.UserDAO;
import org.springframework.jdbc.roma.demo.model.Permission;
import org.springframework.jdbc.roma.demo.model.Role;
import org.springframework.jdbc.roma.demo.model.User;
import org.springframework.test.jdbc.JdbcTestUtils;

public class RowMapperDemo {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("/roma-demo-context.xml");
		
		initDB(context);
		
		final UserDAO userDAO = context.getBean(UserDAO.class);
		
		StringBuffer sb = new StringBuffer();
		for (User u : userDAO.list()) {
			sb.append("Username: " + u.getUsername()).append("\n");
			sb.append("Roles: ").append("\n");
			for (Role r : u.getRoles()) {
				sb.append("\t" + "Role Name: " + r.getName()).append("\n");
				for (Permission p : r.getPermissions()) {
					sb.append("\t\t" + "Permission Name: " + p.getName()).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
	
	private static void initDB(ApplicationContext context) {
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		JdbcTestUtils.executeSqlScript(jdbcTemplate, new ClassPathResource("/db/dbCreationScripts.sql"), true);
		JdbcTestUtils.executeSqlScript(jdbcTemplate, new ClassPathResource("/db/dbInsertionScripts.sql"), true);
	}

}
