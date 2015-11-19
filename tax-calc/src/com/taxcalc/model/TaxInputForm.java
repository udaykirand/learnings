package com.taxcalc.model;

import java.math.BigDecimal;

/**
 * following class is use as data transfer object
 * 
 * @author Uday
 * 
 */
public class TaxInputForm implements IInputFormBean {

	private boolean domesticTaxPercentage = false;
	private boolean additionalImportedTaxPercentage = false;
	private boolean exemptTax = false;
	private String goodsName = "";
	private BigDecimal goodsPrice = new BigDecimal(0);
	private int goodsquontity = 0;
	private BigDecimal calculateTaxPercentage = new BigDecimal(0);

	/**
	 * @return boolean
	 */
	public boolean isAdditionalImportedTaxPercentage() {
		return additionalImportedTaxPercentage;
	}

	/**
	 * 
	 * @param additionalImportedTaxPercentage
	 */
	public void setAdditionalImportedTaxPercentage(
			boolean additionalImportedTaxPercentage) {
		this.additionalImportedTaxPercentage = additionalImportedTaxPercentage;
	}

	/**
	 * 
	 * @return
	 */

	public boolean isDomesticTaxPercentage() {
		return domesticTaxPercentage;
	}

	/**
	 * 
	 * @param domesticTaxPercentage
	 */
	public void setDomesticTaxPercentage(boolean domesticTaxPercentage) {
		this.domesticTaxPercentage = domesticTaxPercentage;
	}

	public boolean isExemptTax() {
		return exemptTax;
	}

	/**
	 * 
	 * @param exemptTax
	 */
	public void setExemptTax(boolean exemptTax) {
		this.exemptTax = exemptTax;
	}

	/**
	 * 
	 * @return
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * 
	 * @param goodsName
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * 
	 * @return
	 */
	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	/**
	 * 
	 * @param goodsPrice
	 */
	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	/**
	 * 
	 * @return
	 */
	public int getGoodsquontity() {
		return goodsquontity;
	}

	/**
	 * 
	 * @param goodsquontity
	 */
	public void setGoodsquontity(int goodsquontity) {
		this.goodsquontity = goodsquontity;
	}

	/**
	 * 
	 * @return
	 */
	public BigDecimal getCalculateTaxPercentage() {
		return calculateTaxPercentage;
	}

	/**
	 * 
	 * @param calculateTaxPercentage
	 */
	public void setCalculateTaxPercentage(BigDecimal calculateTaxPercentage) {
		this.calculateTaxPercentage = calculateTaxPercentage;
	}

	@Override
	public String toString() {
		System.out.println("Input Data ");
		System.out
				.println("----------------------------------------------------------------------------------------------------------- ");
		return "\n\n " + "Goods Name=" + getGoodsName() + "\n "
				+ "Goods Quontity=" + getGoodsquontity() + "\n "
				+ "Good sPrice=" + getGoodsPrice();
	}
}