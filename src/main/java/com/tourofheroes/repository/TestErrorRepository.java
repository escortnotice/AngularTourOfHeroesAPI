package com.tourofheroes.repository;

import java.sql.SQLDataException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tourofheroes.constantsandenums.CustomErrorCodeAndMessages;
import com.tourofheroes.customexception.CustomRepositoryException;

@Repository
public class TestErrorRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestErrorRepository.class);
	
	public void getDataFromDBonError() throws CustomRepositoryException {
		
		try {
			
			//this is used just to simulate the error situation.
			throw new SQLDataException("DB Connection Error.");
			
		}
		
		/*
		 * 1. Print the stack trace of the error
		 * 2. Throw a custom exception with custom error-message and error-code passed as an enum object
		 */
		catch(SQLException e) {
			LOGGER.error(CustomErrorCodeAndMessages.DATABASE_ERROR.getErrorCodeAndMessage() ,e);
			throw new CustomRepositoryException(CustomErrorCodeAndMessages.DATABASE_ERROR);
		}
		
	}

}
