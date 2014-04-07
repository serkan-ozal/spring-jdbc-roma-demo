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

package org.springframework.jdbc.roma.demo.model;

/**
 * @author Serkan ÖZAL
 */
public enum Language {

	TURKISH(1),
	ENGLISH(2),
	GERMAN(3),
	FRENCH(4),
	ITALIAN(5),
	SPANISH(6),
	RUSSIAN(7),
	CHINESE(8),
	JAPANESE(9),
	ARABIC(10),
	OTHER(11);
	
	int code;
	
	Language(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
}
