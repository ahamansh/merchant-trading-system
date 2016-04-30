package com.mts.system.controller;

import com.mts.system.constants.SystemConstants;
import com.mts.system.data.Answer;
import com.mts.system.data.Vendor;
import com.mts.system.exception.InvalidRates;


/**
 * Class responsible for handling the questions. 
 * As an extension we can have a separate implementation based on the different algorithms and in factory have a substitution to use dynamic polymorphism.
 * @author skrishan
 *
 */
public interface QuestionHandler {

	public Answer handle(String line, SystemConstants.LineType type, Vendor seller) throws InvalidRates;	

}
