package com.tourofheroes.service;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourofheroes.constants.CustomErrorMessages;
import com.tourofheroes.customexception.CustomRepositoryException;
import com.tourofheroes.customexception.CustomServiceException;
import com.tourofheroes.repository.TestErrorRepository;

@Service
public class TestErrorService {

	@Autowired
	TestErrorRepository testErrorRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(TestErrorService.class);

	public void testBusinessServiceException() throws CustomServiceException {

		try {
			//this is to simulate the error thrown
			throw new FileNotFoundException("xyz.txt file not found.");
		}

		/*
		 * 1. Print the stack trace of the error if occured in service layer
		 * 2. Throw a custom exception with custom message to be propogated or displayed
		 */
		catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage(),e);  //error-stack is thrown in the log
			throw new CustomServiceException(CustomErrorMessages.FILE_NOTFOUNDERROR_MESSAGE);
		}
	}

	
	public void testRepoServiceException() throws CustomServiceException, CustomRepositoryException {

		try {

			testErrorRepo.getDataFromDBonError();
		}
		
		/*
		 * 1. Print the stack trace of the error if occured in service layer
		 * 2. Throw a custom exception with custom message to be propogated or displayed in UI
		 */
		catch (RuntimeException e) {
			LOGGER.error(e.getMessage(),e);
			throw new CustomServiceException(CustomErrorMessages.SOME_BUSINESSERROR_MESSAGE);
		}
	}
}
