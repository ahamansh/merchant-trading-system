package com.mts.system.data;

import java.util.HashMap;
import java.util.Map;

import com.mts.system.comodity.Metal;
import com.mts.utils.CommonUtil;

/**
 * Vendor is a Merchant and has a list of metals to sell.
 * @author skrishan
 *
 */
public class Vendor extends Merchant {

	//	has list of metals
	// can be in a group if need to sell only one metal

	private String vendorName = CommonUtil.EMPTY_STRING;

	private Map<String,Metal> listOfMetalsToSell;



	public Metal getMetalDetails(String metalName){

		if(this.listOfMetalsToSell.containsKey(metalName))
			return this.listOfMetalsToSell.get(metalName);

		return null;

	}

	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
		listOfMetalsToSell = new HashMap<String,Metal>();
	}

	public void addMetalDetails(String metalName,Metal metal){

		this.listOfMetalsToSell.put(metalName, metal);

	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((vendorName == null) ? 0 : vendorName.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendor other = (Vendor) obj;
		if (vendorName == null) {
			if (other.vendorName != null)
				return false;
		} else if (!vendorName.equals(other.vendorName))
			return false;
		return true;
	}



}
