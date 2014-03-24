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

package org.springframework.jdbc.romademo.v2.dao.jdbc;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.romademo.common.dao.BaseJdbcDAO;
import org.springframework.jdbc.romademo.v2.dao.CreditCardInfoDAO;
import org.springframework.jdbc.romademo.v2.model.CreditCardInfo;
import org.springframework.stereotype.Repository;

/**
 * @author Serkan ÖZAL
 */
@Repository(value="creditCardInfoDAO_v2")
public class CreditCardInfoJdbcDAO extends BaseJdbcDAO implements CreditCardInfoDAO {

	private RowMapper<CreditCardInfo> creditCardInfoRowMapper;

	@PostConstruct
	protected void init() {
		creditCardInfoRowMapper = rowMapperService.getRowMapper(CreditCardInfo.class);
	}
	
	@Override
	public CreditCardInfo get(Long id) {
		try {
			return 
				jdbcTemplate.queryForObject(
					"SELECT c.* FROM CREDIT_CARD_INFO c WHERE c.id = ?", creditCardInfoRowMapper, id);
		}
		catch (EmptyResultDataAccessException e) {
			return null;
		}	
	}

	@Override
	public void add(CreditCardInfo creditCardInfo) throws Exception {
		jdbcTemplate.update(
			"INSERT INTO CREDIT_CARD_INFO (credit_card_number, security_code, expiration_date) " + 
			"VALUES (?, ?, ?) ", 
			creditCardInfo.getCreditCardNumber(), creditCardInfo.getSecurityCode(), creditCardInfo.getExpirationDate());
	}

	@Override
	public List<CreditCardInfo> list() {
		return jdbcTemplate.query("SELECT c.* FROM CREDIT_CARD_INFO c", creditCardInfoRowMapper);
	}

	@Override
	public void addUserCreditCardInfo(Long userId, CreditCardInfo creditCardInfo) throws Exception {
		jdbcTemplate.update(
			"INSERT INTO USER_CREDIT_CARD_INFO (user_id, credit_card_info_id) " + 
			"VALUES (?, ?) ", userId, creditCardInfo.getId());
	}

	@Override
	public CreditCardInfo getUserCreditCardInfo(Long userId) {
		return 
			jdbcTemplate.queryForObject(
					"SELECT c.* FROM CREDIT_CARD_INFO c WHERE c.id = " +
					"(" +
						"SELECT uc.credit_card_info_id FROM USER_CREDIT_CARD_INFO uc WHERE uc.user_id = " + userId +
					")", 
					creditCardInfoRowMapper);
	}

}
