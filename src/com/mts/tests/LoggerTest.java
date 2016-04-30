package com.mts.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mts.logger.LogHandler;
import com.mts.system.SystemFactory;
import com.mts.system.exception.InvalidRates;

public class LoggerTest {

	LogHandler log;

	@Before
	public void setUp() throws Exception {

		log = SystemFactory.getLogger(LoggerTest.class);
		log.logDebug("Starting Log Testing ...");
	}
	
	
	@Test
	public void LogTestForAllMethods() {
		log.logDebug("This is DebugLog ");
		log.logError("This is Error Log");
		log.logInfo("This is Info Log");
		log.logWarning("This is warning Log");
		log.logException(new InvalidRates("Exception Test"));
	}

	@After
	public void tearDown(){

		log.logDebug("Log testing Completed .....");
	}

}
