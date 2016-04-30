package com.mts.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.mts.system.MarketRates;
import com.mts.system.SystemFactory;
import com.mts.system.controller.AssignementHandler;
import com.mts.system.exception.MarketRateException;

public class AssignmentTest {

	AssignementHandler assignmentDelegate = null;

	@Before
	public void setUp(){

		assignmentDelegate = SystemFactory.getAssignmentHandlerInstance();
	}

	@Test
	public void addMarketRateTest() throws MarketRateException{

		String dummyRatesUserInput = "prok is V";

		assignmentDelegate.evaluateAndAddMarketRate(dummyRatesUserInput);
		assertEquals("Market Rated not added properly", "V", MarketRates.getMarketRateInstance().getSymbolRate("prok"));

	}


	@Test(expected = MarketRateException.class)
	public void UserEnteredMarketRatesAreNotNull() throws MarketRateException {

		assignmentDelegate.evaluateAndAddMarketRate("");
	}

}
