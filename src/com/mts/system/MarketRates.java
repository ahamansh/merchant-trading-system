/**
 * 
 */
package com.mts.system;

import java.util.HashMap;
import java.util.Map;

/**
 * Market rate is the rate which is finalized and earth person enters to do the processing
 * it is key-value pair for mapping with roman numbers.
 * Static factory used for now as requirement is not clear if we need to use a single class or mapped to a planet :)
 * @author skrishan
 *
 */
public class MarketRates {

	private Map<String,String> ratesAgreedUpon;

	private static MarketRates currentMarket = new MarketRates();

	private MarketRates(){

		ratesAgreedUpon = new HashMap<String,String>();
	}


	public String getSymbolRate(String key){

		return ratesAgreedUpon.get(key);
	}

	public boolean doesRateExists(String key){

		return ratesAgreedUpon.containsKey(key);
	}

	public void addSymbolRate(String key,String value){

		ratesAgreedUpon.put(key, value);
	}

	public static MarketRates getMarketRateInstance(){

		return currentMarket;
	}
}
