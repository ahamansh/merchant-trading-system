package com.mts.system.controller;

import com.mts.system.MarketRates;
import com.mts.system.exception.MarketRateException;
import com.mts.system.validators.SystemValidator;
import com.mts.system.validators.TradeValidator;
import com.mts.utils.CommonUtil;

/**
 * Concrete Implementation of InputHander.
 * handles input for assignment and credit statements 
 * @author skrishan
 *
 */
public class AssignmentService implements AssignementHandler {


	TradeValidator _validator;

	public AssignmentService() {
		super();
		this._validator = new SystemValidator();
	}

	@Override
	public void evaluateAndAddMarketRate(String finalRateSentnce)
			throws MarketRateException {

		if(!CommonUtil.isNullString(finalRateSentnce)){
			String [] parts = finalRateSentnce.split(" ");
			addOrOverrideMarketRate(parts[0],parts[2]);
		}else
			throw new MarketRateException();

	}

	private void addOrOverrideMarketRate(String key, String value) {
		MarketRates.getMarketRateInstance().addSymbolRate(key, value);
	}



}
