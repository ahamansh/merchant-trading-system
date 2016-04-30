package com.mts.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.mts.system.SystemFactory;
import com.mts.system.controller.AssignementHandler;
import com.mts.system.controller.CreditsHandler;
import com.mts.system.controller.QuestionHandler;
import com.mts.system.core.LineRegEx;
import com.mts.system.data.Answer;
import com.mts.system.data.Vendor;
import com.mts.system.exception.InvalidRates;

public class QuestionTest {

	AssignementHandler assignRate =  null;
	CreditsHandler creditDelegate = null;
	QuestionHandler questionDelegate = null;
	Vendor _seller = null;

	@Before
	public void setUp() throws Exception {
		assignRate = SystemFactory.getAssignmentHandlerInstance();
		creditDelegate = SystemFactory.getCreditsHandlerInstance();
		_seller = SystemFactory.getSellerInstance();
		questionDelegate = SystemFactory.getQuestionHandlerInstance();

		String userEnteredCreditStmt = "glob glob Silver is 34 Credits";

		assignRate.evaluateAndAddMarketRate("glob is I");
		assignRate.evaluateAndAddMarketRate("prok is V");
		assignRate.evaluateAndAddMarketRate("pish is X");
		assignRate.evaluateAndAddMarketRate("tegj is L");
		creditDelegate.processMetalCredit(userEnteredCreditStmt, _seller);
	}

	@Test
	public void HowMuchQuestionTest() throws InvalidRates {

		String userAskedQuestion = "how much is pish tegj glob glob ?";
		Answer answer = questionDelegate.handle(userAskedQuestion, LineRegEx.Question_HOW_MUCH.getType(), _seller);
		assertTrue(answer.getAnswer().contains("42"));
	}

	@Test
	public void HowManyQuestionTest() throws InvalidRates {

		String userAskedQuestion = "how many Credits is glob prok Silver ?";
		Answer answer = questionDelegate.handle(userAskedQuestion, LineRegEx.Question_HOW_MANY.getType(), _seller);
		assertTrue(answer.getAnswer().contains("68"));
	}

}
