package com.mts.system.data;

import com.mts.system.MarketRates;
import com.mts.utils.CommonUtil;

/**
 * Common class for Vendor and Consumer have planet id to relate to planed and has a market rates.
 * @author skrishan
 *
 */
public abstract class Merchant {

	private String planetId = CommonUtil.EMPTY_STRING;

	private MarketRates agreedConversationPattern;

	public String getPlanetId() {
		return planetId;
	}

	public void setPlanetId(String planetId) {
		this.planetId = planetId;
	}

	public MarketRates getAgreedConversationPattern() {
		return agreedConversationPattern;
	}

	public void setAgreedConversationPattern(MarketRates agreedConversationPattern) {
		this.agreedConversationPattern = agreedConversationPattern;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((planetId == null) ? 0 : planetId.hashCode());
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
		Merchant other = (Merchant) obj;
		if (planetId == null) {
			if (other.planetId != null)
				return false;
		} else if (!planetId.equals(other.planetId))
			return false;
		return true;
	}


}
