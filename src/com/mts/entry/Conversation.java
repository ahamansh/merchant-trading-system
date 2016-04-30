package com.mts.entry;

import java.util.Scanner;
import java.util.regex.Matcher;

import com.mts.display.UserDisplay;
import com.mts.system.SystemFactory;
import com.mts.system.controller.AssignementHandler;
import com.mts.system.controller.CreditsHandler;
import com.mts.system.controller.QuestionHandler;
import com.mts.system.core.LineRegEx;
import com.mts.system.data.Vendor;
import com.mts.system.exception.ImproperSymbolOrdering;
import com.mts.system.exception.InvalidRates;
import com.mts.system.exception.MarketRateException;
import com.mts.system.helper.AnswerHelper;

/**
 * Conversation between user and system.
 * Starting Entity for the system.
 * class will wait for the inputs from the user and do the processing accordingly
 * @author skrishan
 *
 */
public class Conversation implements SystemStarter,ConversationTester{

	private Scanner inputScanner;
	private Matcher matcher;

	private Vendor _seller;

	AssignementHandler assignmentDelegate;
	CreditsHandler creditsDelegate;
	QuestionHandler questionDelegate;

	public Conversation(Scanner inputScanner) {
		super();
		this.inputScanner = inputScanner;
		this._seller = SystemFactory.getSellerInstance();
		this.assignmentDelegate = SystemFactory.getAssignmentHandlerInstance();
		this.creditsDelegate = SystemFactory.getCreditsHandlerInstance();
		this.questionDelegate = SystemFactory.getQuestionHandlerInstance();

	}


	public void start(){
		try
		{
			while(inputScanner.hasNext())
			{
				process(inputScanner.nextLine());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			inputScanner.close();
		}

	}


	public void process(String lineContents)
	{

		LineRegEx[] lineRegEx = LineRegEx.values();
		boolean matchFound = false;
		//		lineContents = inputScanner.nextLine();

		if(lineContents.length() > 0)
		{
			for(LineRegEx l : lineRegEx)
			{
				matcher = l.getPattern().matcher(lineContents);

				if(matcher.matches())
				{
					switch(l.getType())
					{
					case ASSIGNMENT:
						matchFound = true;
						try{
							assignmentDelegate.evaluateAndAddMarketRate(lineContents);
						}catch (MarketRateException e) {
							UserDisplay.promptUser(e.getMessage());
						}
						break;

					case CREDITSINFO:
						// CreditsInfo processing.
						matchFound = true;
						try{
							creditsDelegate.processMetalCredit(lineContents,_seller);
						}catch (InvalidRates e) {
							UserDisplay.promptUser(e.getMessage());
						}catch (ImproperSymbolOrdering e) {
							UserDisplay.promptUser(e.getMessage());
						}
						break;

					case QUESTION_HOW_MANY:
						// How many types processing.
						matchFound = true;
						try{
							AnswerHelper.processAnswer(questionDelegate.handle(lineContents,l.getType(), _seller));
						}catch (Exception e) {
							UserDisplay.promptUser(e.getMessage());
						}
						break;

					case QUESTION_HOW_MUCH:
						// How much types processing.
						matchFound = true;
						try{
							AnswerHelper.processAnswer(questionDelegate.handle(lineContents,l.getType(), null));
						}catch (Exception e) {
							UserDisplay.promptUser(e.getMessage());
						}
						break;
					}
				}

				if(matchFound)
				{
					break;
				}
			}

			if(!matchFound)
			{
				UserDisplay.displayNoIdea();
			}
		}
	}


	@Override
	public Scanner getScanner() {
		// TODO Auto-generated method stub
		return inputScanner;
	}


}
