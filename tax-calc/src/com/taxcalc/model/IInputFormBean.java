package com.taxcalc.model;

import java.math.BigDecimal;

/**
 * Following Interface is using as a contract for DTO
 * 
 * @author Uday
 * 
 */
public interface IInputFormBean {

	/**
	 * Following method will use for isAdditionalImportedTaxPercentage
	 * 
	 * @return
	 */
	public boolean isAdditionalImportedTaxPercentage();

	/**
	 * Following method will use for setAdditionalImportedTaxPercentage
	 * 
	 * @param additionalImportedTaxPercentage
	 */
	public void setAdditionalImportedTaxPercentage(
			boolean additionalImportedTaxPercentage);

	/**
	 * Following method will use for isDomesticTaxPercentage
	 * 
	 * @return
	 */

	public boolean isDomesticTaxPercentage();

	/**
	 * Following method will use for setDomesticTaxPercentage
	 * 
	 * @param domesticTaxPercentage
	 */
	public void setDomesticTaxPercentage(boolean domesticTaxPercentage);

	/**
	 * Following method will use for isExemptTax
	 * 
	 * @return
	 */
	public boolean isExemptTax();

	/**
	 * Following method will use for setExemptTax
	 * 
	 * @param exemptTax
	 */
	public void setExemptTax(boolean exemptTax);

	/**
	 * Following method will use for getGoodsName
	 * 
	 * @return
	 */
	public String getGoodsName();

	/**
	 * Following method will use for setGoodsName
	 * 
	 * @param goodsName
	 */
	public void setGoodsName(String goodsName);

	/**
	 * Following method will use for getGoodsPrice
	 * 
	 * @return
	 */
	public BigDecimal getGoodsPrice();

	/**
	 * Following method will use for setGoodsPrice
	 * 
	 * @param goodsPrice
	 */
	public void setGoodsPrice(BigDecimal goodsPrice);

	/**
	 * Following method will use for getGoodsquontity
	 * 
	 * @return
	 */
	public int getGoodsquontity();

	/**
	 * Following method will use for setGoodsquontity
	 * 
	 * @param goodsquontity
	 */
	public void setGoodsquontity(int goodsquontity);

	/**
	 * Following method will use for getCalculateTaxPercentage
	 * 
	 * @return
	 */
	public BigDecimal getCalculateTaxPercentage();

	/**
	 * Following method will use for setCalculateTaxPercentage
	 * 
	 * @param calculateTaxPercentage
	 */
	public void setCalculateTaxPercentage(BigDecimal calculateTaxPercentage);

}