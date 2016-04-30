/**
 * 
 */
package com.mts.system.comodity;

import com.mts.utils.CommonUtil;

/**
 * Earths individual vendors go out to sell metals.
 * Metals has UOM for the calculation purpose and attributes which can be later enhanced to differenciate based on properties
 * MetalName is the comparision Like Silver,Iron,etc..
 * Each vendor can have metals and with some quntity (If needed)
 * @author skrishan
 *
 */
public class Metal {

	private String metalName = CommonUtil.EMPTY_STRING;
	private int quantity;

	private MetalUOM unitOfMeasurement;

	private MetalAttributes differentiatorAttributes;

	public int getQuantity() {
		return quantity;
	}

	public Metal(String metalName,double unitRate) {
		super();
		this.metalName = metalName;
		this.unitOfMeasurement = new MetalUOM(unitRate);
	}

	public Metal(String metalName,double originalRate,int conversionFactor) {
		super();
		this.metalName = metalName;
		this.unitOfMeasurement = new MetalUOM(originalRate,conversionFactor);
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MetalUOM getUnitOfMeasurement() {
		return unitOfMeasurement;
	}


	public MetalAttributes getDifferentiatorAttributes() {
		return differentiatorAttributes;
	}


	public double getUnitPrice(){

		return this.unitOfMeasurement.getUnitPrice();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((metalName == null) ? 0 : metalName.hashCode());
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
		Metal other = (Metal) obj;
		if (metalName == null) {
			if (other.metalName != null)
				return false;
		} else if (!metalName.equals(other.metalName))
			return false;
		return true;
	}




}
