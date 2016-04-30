package com.mts.system.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.mts.display.UserDisplay;
import com.mts.system.SystemFactory;
import com.mts.system.comodity.Metal;
import com.mts.system.core.RomanNumbers.Numeral;
import com.mts.system.exception.ImproperSymbolOrdering;
import com.mts.system.validators.SystemValidator;
import com.mts.system.validators.TradeValidator;

/**
 * Concrete implementaion of RomanNumberHandler.
 * Handles queries related to Roman number
 * @author skrishan
 *
 */
public class RomanNumberService implements RomanNumberHandler {

	TradeValidator _validator;
	Pattern pattern;

	public RomanNumberService() {
		// TODO Auto-generated constructor stub
		this._validator = new SystemValidator();
	}

	@Override
	public Metal evaluate(String metalName,double creaditValue,String romanNumeral) throws ImproperSymbolOrdering
	{



		try{

			int finalNumber = convertToNumber(romanNumeral);		
			return SystemFactory.getMetalInstance(metalName, creaditValue, finalNumber);

		}catch(ImproperSymbolOrdering e){

			throw e;

		}
	}

	private List<Integer> assignSigns(List<Integer> numbers)
	{
		int currentElement;
		//dont negate the last number , as is to be added everytime.
		for(int i = 0 ; i < numbers.size() -1; i++)
		{
			currentElement = numbers.get(i);
			if( currentElement < numbers.get(i+1))
			{
				numbers.set(i, -currentElement);
			}
		}
		return numbers;
	}

	private List<Integer> getNumbers(char [] parts)
	{
		int result;
		
		
		List<Integer> numbers = new ArrayList();


		for(char c : parts)
		{
			result = getNumberFromChar(c);
			if(result != -1)
			{
				numbers.add(result);
			}
			else
			{
				UserDisplay.promptUser("Incorrect Roman Numeral.");
			}
		}
		return numbers;
	}

	private int getNumberFromChar(char numeral)
	{
		int temp = -1;
		switch(numeral)
		{
		case 'I' : 
			temp = Numeral.I.getNumber();
			break;
		case 'V' : 
			temp = Numeral.V.getNumber();
			break;
		case 'L' : 
			temp = Numeral.L.getNumber(); 
			break;
		case 'X' : 
			temp = Numeral.X.getNumber();
			break;
		case 'C' : 
			temp = Numeral.C.getNumber();
			break;
		case 'D' : 
			temp = Numeral.D.getNumber();
			break;
		case 'M' : 
			temp = Numeral.M.getNumber();
			break;
		default:
			UserDisplay.promptUser("Invalid Entry");
		}
		return temp;
	}

	@Override
	public int convertToNumber(String romanNumber) throws ImproperSymbolOrdering {
		// TODO Auto-generated method stub

		List<Integer> numbers = getNumbers(romanNumber.toCharArray());
		numbers = assignSigns(numbers);

		int  finalNumber=0;

		//check the Roman Numeral validity.
		if(!_validator.violatesRomanRepetition(romanNumber,pattern))
		{
			if(!_validator.violatesSubtractionOrder(numbers))
			{
				if(numbers.size() > 0)
				{
					//The number is a valid Roman numeral, time to convert it into number.
					for(int i : numbers)
					{
						finalNumber += i;
					}
					return finalNumber;
				}
			}
			else
			{				
				throw new ImproperSymbolOrdering("Subtraction condition not met.");
			}
		}else
			throw new ImproperSymbolOrdering("Repetition of roman not proper");

		return 0;
	}

}
