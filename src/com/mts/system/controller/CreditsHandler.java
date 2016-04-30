package com.mts.system.controller;

import com.mts.system.data.Vendor;
import com.mts.system.exception.ImproperSymbolOrdering;
import com.mts.system.exception.InvalidRates;

public interface CreditsHandler {

	public void processMetalCredit(String lineContents,Vendor _dataObj) throws InvalidRates, ImproperSymbolOrdering;

}
