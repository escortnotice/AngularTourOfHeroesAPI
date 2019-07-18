package com.tourofheroes.repository;

import java.sql.SQLDataException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tourofheroes.constants.CustomErrorMessages;
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
		 * 1. Print the stack trace of the error if occured in repository layer
		 * 2. Throw a custom exception with custom message to be propogated or displayed in UI
		 */
		catch(SQLException e) {
			LOGGER.error(e.getMessage(),e);
			throw new CustomRepositoryException(CustomErrorMessages.DATABASE_ERROR);
		}
		
	}

}
