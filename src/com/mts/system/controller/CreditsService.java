package com.mts.system.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mts.system.SystemFactory;
import com.mts.system.comodity.Metal;
import com.mts.system.core.LineRegEx;
import com.mts.system.data.Vendor;
import com.mts.system.exception.ImproperSymbolOrdering;
import com.mts.system.exception.InvalidRates;
import com.mts.system.helper.NumericHelper;
import com.mts.system.validators.SystemValidator;
import com.mts.system.validators.TradeValidator;

public class CreditsService implements CreditsHandler{

	TradeValidator _validator;
	Pattern pattern;

	public CreditsService() {
		super();
		this._validator = new SystemValidator();
	}


	@Override
	public void processMetalCredit(String creditStmt,Vendor _dataObj) throws InvalidRates,
	ImproperSymbolOrdering {
		// TODO Auto-generated method stub

		this.pattern = LineRegEx.CreditsInfo.getPattern();
		Matcher m = pattern.matcher(creditStmt);
		m.matches();

		String [] vulcanNumbers = m.group(1).split("\\s");
		String currencyName = m.group(2);
		double creditValue = Double.parseDouble(m.group(3));

		if(!_validator.areRatesValid(vulcanNumbers))
		{
			throw new InvalidRates("Undeclared Vulcan number was used, input ignored.");

		}

		String romanNumerals = NumericHelper.convertToRomanNumeral(vulcanNumbers);

		Metal newMetal = SystemFactory.getRomanNumberService().evaluate(currencyName,creditValue,romanNumerals);

		_dataObj.addMetalDetails(currencyName, newMetal);	


	}
}
