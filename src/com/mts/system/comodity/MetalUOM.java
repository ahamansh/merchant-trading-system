/**
 * 
 */
package com.mts.system.comodity;

import com.mts.system.constants.SystemConstants;

/**
 * Unit of measurement for the Metal.
 * Sole responsibility to have variables which can be used in Metal cost calculation.
 * contains conversion factor, unit price for the metal,original value is the input from user
 * @author skrishan
 *
 */
public class MetalUOM {


	private int conversionFactor = SystemConstants.UNIT_CONVERSION_FACTOR;
	private double unitPrice;
	private double originalCredits;

	public MetalUOM(double unitRate) {
		// TODO Auto-generated constructor stub
		this.unitPrice = unitRate;
	}


	public int getConversionFactor() {
		return conversionFactor;
	}

	public MetalUOM(double originalCredits,int conversionFactor) {
		super();
		this.conversionFactor = conversionFactor;
		this.originalCredits = originalCredits;
		setUnitPrice(getCalculativePrice());

	}


	public void setConversionFactor(int conversionFactor) {

		if(conversionFactor != 0)
			this.conversionFactor = conversionFactor;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getCalculativePrice(){		
		return originalCredits/conversionFactor;
	}


	public double getOriginalCredits() {
		return originalCredits;
	}


	public void setOriginalCredits(double originalCredits) {
		this.originalCredits = originalCredits;
	}

}
