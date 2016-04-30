package com.mts.system.controller;

import com.mts.system.comodity.Metal;
import com.mts.system.exception.ImproperSymbolOrdering;

/**
 * Interface to define the implementation responsibilities. Restricting user to code to interface and can have multiple implementation based on the algorithms.
 * Implementing classes can be initialized from the factory based on the requirement.
 * @author skrishan
 *
 */
public interface RomanNumberHandler {


	public Metal evaluate(String metalName,double creaditValue,String romanNumeral)throws ImproperSymbolOrdering;

	public int convertToNumber(String romanNumber) throws ImproperSymbolOrdering;
}
