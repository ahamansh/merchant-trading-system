package com.mts.system.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mts.display.UserDisplay;
import com.mts.system.SystemFactory;
import com.mts.system.constants.SystemConstants;
import com.mts.system.constants.SystemConstants.LineType;
import com.mts.system.core.LineRegEx;
import com.mts.system.data.Answer;
import com.mts.system.data.Vendor;
import com.mts.system.exception.ImproperSymbolOrdering;
import com.mts.system.exception.InvalidRates;
import com.mts.system.helper.NumericHelper;
import com.mts.system.validators.TradeValidator;

/**
 * Concrete Implemetation of QuestionHandler.
 * Handles input for Question.
 * @author skrishan
 *
 */
public class QuestionService implements QuestionHandler {

	Pattern pattern;
	TradeValidator _validator;



	public QuestionService() {
		super();
		_validator = SystemFactory.getTradeValidator();
	}




	public Answer handleHowMany(String line,Vendor seller) throws InvalidRates
	{

		pattern = LineRegEx.Question_HOW_MANY.getPattern();
		Matcher m = pattern.matcher(line);
		m.matches();

		String creditName = m.group(1);
		String [] vulcanNumbers = m.group(2).split("\\s");
		String currencyName = m.group(3);


		if(!_validator.areRatesValid(vulcanNumbers))
		{
			throw new InvalidRates("Undeclared number was used, question ignored.");
		}

		String romanNumerals = NumericHelper.convertToRomanNumeral(vulcanNumbers);
		int materialQuantitiy = -1;
		try {
			materialQuantitiy = SystemFactory.getRomanNumberService().convertToNumber(romanNumerals);
		} catch (ImproperSymbolOrdering e) {
			UserDisplay.promptUser(e.getMessage());
		}catch (Exception e) {
			UserDisplay.promptUser(e.getMessage());
		}

		if(materialQuantitiy != -1)
		{
			double totalCredits = materialQuantitiy * seller.getMetalDetails(currencyName).getUnitPrice(); 

			StringBuilder result = new StringBuilder();

			result.append(m.group(2)+  currencyName + " is " + totalCredits + " " + creditName);

			return new Answer(result.toString());
		}
		return null;
	}


	public Answer handleHowMuch(String line) throws InvalidRates
	{

		pattern = LineRegEx.Question_HOW_MUCH.getPattern();
		Matcher m = pattern.matcher(line);


		m.matches();
		String  inputs =  m.group(1);

		if(_validator.areRatesValid(inputs.split(" ")))
		{
			String romanNumeral = NumericHelper.convertToRomanNumeral(inputs.split(" "));
			//XLII
			int number = -1;
			try {
				number = SystemFactory.getRomanNumberService().convertToNumber(romanNumeral);
			} catch (ImproperSymbolOrdering e) {
				// TODO Auto-generated catch block
				UserDisplay.promptUser(e.getMessage());
			}
			if(number != -1 )
			{
				return new Answer(inputs + " is " + number +".");
			}
			else
			{
				return null;
			}
		}else{
			throw new InvalidRates("Undeclared number was used, question ignored.");
		}
	}



	@Override
	public Answer handle(String line, LineType type, Vendor seller) throws InvalidRates {
		// TODO Auto-generated method stub

		Answer answer = null;

		if(type == SystemConstants.LineType.QUESTION_HOW_MANY)
		{
			answer = handleHowMany(line,seller);
		}
		else if(type == SystemConstants.LineType.QUESTION_HOW_MUCH)
		{
			answer =handleHowMuch(line);
		}

		return answer;
	}

}
