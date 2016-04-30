package com.mts.system.helper;

import com.mts.system.MarketRates;

/**
 * Helper class for Numeric processing
 * @author skrishan
 *
 */
public class NumericHelper {

	public NumericHelper() {
		// TODO Auto-generated constructor stub
	}


	public static String convertToRomanNumeral(String[] vNumeral)
	{
		StringBuilder romanNumeral = new StringBuilder(vNumeral.length);

		for(String s : vNumeral)
		{
			romanNumeral.append(MarketRates.getMarketRateInstance().getSymbolRate(s));
		}

		return romanNumeral.toString();
	}



}
