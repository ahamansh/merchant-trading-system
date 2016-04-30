package com.mts.system.validators;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Interface to validation. For the system.
 * @author skrishan
 *
 */
public interface TradeValidator {

	public boolean areRatesValid(String [] numeral);

	public boolean violatesRomanRepetition(String romanNumeral,Pattern pattern);

	public boolean violatesSubtractionOrder(List<Integer> numbers);
}
