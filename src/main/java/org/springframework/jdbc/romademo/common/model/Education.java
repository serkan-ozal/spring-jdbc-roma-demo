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

package org.springframework.jdbc.romademo.common.model;

/**
 * @author Serkan ÖZAL
 */
public enum Education {

	PRIMARY_SCHOOL(1),
	SECONDARY_SCHOOL(2),
	HIGH_SCHOOL(3),
	BACHELOR(4),
	MASTER(5),
	PHD(6),
	ASSOCIATE_PROFESSOR(7),
	PROFESSOR(8),
	OTHER(9);
	
	int code;
	
	Education(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

}
