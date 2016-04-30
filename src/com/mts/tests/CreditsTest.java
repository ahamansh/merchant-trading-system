package com.mts.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.mts.system.SystemFactory;
import com.mts.system.comodity.Metal;
import com.mts.system.controller.AssignementHandler;
import com.mts.system.controller.CreditsHandler;
import com.mts.system.data.Vendor;
import com.mts.system.exception.ImproperSymbolOrdering;
import com.mts.system.exception.InvalidRates;

public class CreditsTest {

	CreditsHandler creditDelegate = null;
	Vendor _seller = null;


	@Before
	public void setUp() throws Exception {
		AssignementHandler assignRate = SystemFactory.getAssignmentHandlerInstance();
		assignRate.evaluateAndAddMarketRate("glob is I");
		assignRate.evaluateAndAddMarketRate("pish is X");
		creditDelegate = SystemFactory.getCreditsHandlerInstance();
		_seller = SystemFactory.getSellerInstance();

	}

	@Test
	public void AddMetalCreditWithMarketRateSetTest() throws InvalidRates, ImproperSymbolOrdering {

		String userEnteredCreditStmt = "glob glob Silver is 34 Credits";

		creditDelegate.processMetalCredit(userEnteredCreditStmt, _seller);
		assertEquals("Credits not added properly", new Metal("Silver", 17), _seller.getMetalDetails("Silver"));


	}

	@Test(expected = InvalidRates.class)
	public void AddMetalCreditWithNoMarketRateTest() throws InvalidRates, ImproperSymbolOrdering{

		String userEnteredCreditStmt = "bhindi aloo Silver is 34 Credits";
		creditDelegate.processMetalCredit(userEnteredCreditStmt, _seller);
	}

	@Test(expected = ImproperSymbolOrdering.class)
	public void AddMetalCreditWithImproperOrderTest() throws InvalidRates, ImproperSymbolOrdering{

		String userEnteredCreditStmt = "pish pish pish pish Silver is 34 Credits";
		creditDelegate.processMetalCredit(userEnteredCreditStmt, _seller);
	}

}
