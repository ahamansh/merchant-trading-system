package com.mts.system.controller;

import com.mts.system.exception.MarketRateException;

/**
 * Interface to define the implementation responsibilities. Restricting user to code to interface and can have multiple implementation based on the algorithms.
 * Implementing classes can be initialized from the factory based on the requirement.
 * @author skrishan
 *
 */
public interface AssignementHandler {	

	public void evaluateAndAddMarketRate(String lineContents) throws MarketRateException;	

}
