/**
 * 
 */
package com.mts.system.validators;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mts.display.UserDisplay;
import com.mts.system.MarketRates;
import com.mts.system.core.RomanNumbers.Numeral;

/**
 * Concrete implementation of TradeValidator.
 * Handles Validation in the system.
 * @author skrishan
 *
 */
public class SystemValidator implements TradeValidator {

	private String [] repetitionTest = {"(IIII+)","(XXXX+)", "(CCCC+)", "(MMMM+)", "(DD+)", "(LL+)", "(VV+)"};
	private boolean doesRateExists(String numeral){
		return MarketRates.getMarketRateInstance().doesRateExists(numeral);		
	}

	public boolean areRatesValid(String [] numeral)
	{
		for (String s : numeral)
		{
			if(!doesRateExists(s))
			{
				UserDisplay.promptUser(s+": Not found in Market Rates, Please check the question format");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean violatesRomanRepetition(String romanNumeral,Pattern pattern)
	{
		String regex ="";
		for(int i =0 ; i < repetitionTest.length; i ++)
		{
			regex = repetitionTest[i];
			pattern = Pattern.compile(regex);
			Matcher m = pattern.matcher(romanNumeral);

			if(m.matches())
			{
				UserDisplay.promptUser("The number entered violates Roman Number repitition constraints.");
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean violatesSubtractionOrder(List<Integer> numbers)
	{
		int number, nextNumber;
		for(int i = 0 ; i < numbers.size()-1; i++)
		{
			number = numbers.get(i);
			nextNumber = Math.abs(numbers.get(i+1));

			if(number > nextNumber)
				continue;

			//V, L , D can never be subtracted.
			if( number == -5 || number == -50 || number == - 500)
			{
				UserDisplay.promptUser("V, L, and D can never be subtracted.");
				return true;
			}

			switch(Math.abs(number))
			{
			case  1:
				// I can only be subtracted from V or X.
				if(nextNumber != Numeral.V.getNumber() && nextNumber != Numeral.X.getNumber() && nextNumber != number )
				{
					UserDisplay.promptUser("I can be subtracted from V and X only.");
					return true;
				}
				break;

			case 10:
				// X can only be subtracted from L or C.
				if(nextNumber != Numeral.L.getNumber() && nextNumber != Numeral.C.getNumber() && nextNumber != number )
				{
					UserDisplay.promptUser("X can be subtracted from L and C only.");
					return true;
				}
				break;

			case 100 :
				// C can only be subtracted from D or M.
				if(nextNumber != Numeral.D.getNumber()&& nextNumber != Numeral.M.getNumber()&& nextNumber != number )
				{
					UserDisplay.promptUser("C can be subtracted from D and M only.");
					return true;
				}
				break;
			}
		}

		return false;
	}

}
