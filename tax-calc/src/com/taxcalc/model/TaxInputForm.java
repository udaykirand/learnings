package com.taxcalc.model;

import java.math.BigDecimal;

/**
 * DTO -- Mantains data related to each line item
 * 
 * @author Uday
 * 
 */
public class TaxInputForm implements IInputFormBean {

    private boolean onlySalesTax = false;
    
    private boolean addnlImportTax = false;
    
    private boolean importTax = false;
    
    private boolean exemptTax = false;
    
    private String productName = "";
    
    private BigDecimal productPrice = new BigDecimal(0);
    
    private int quantity = 0;
    
    private BigDecimal calculatedTax = new BigDecimal(0);

    /**
     * @return boolean
     */
    public boolean isAddnlImportTax() {
	return addnlImportTax;
    }

    /**
     * 
     * @param additionalImportedTaxPercentage
     */
    public void setAddnlImportTax(boolean addnlImportTax) {
	this.addnlImportTax = addnlImportTax;
    }

    /**
     * 
     * @return
     */

    public boolean isOnlySalesTax() {
	return onlySalesTax;
    }

    /**
     * 
     * @param onlySalesTax
     */
    public void setOnlySalesTax(boolean onlySalesTax) {
	this.onlySalesTax = onlySalesTax;
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
    public String getProductName() {
	return productName;
    }

    /**
     * 
     * @param goodsName
     */
    public void setProductName(String productName) {
	this.productName = productName;
    }

    /**
     * 
     * @return
     */
    public BigDecimal getProductPrice() {
	return productPrice;
    }

    /**
     * 
     * @param goodsPrice
     */
    public void setProductPrice(BigDecimal productPrice) {
	this.productPrice = productPrice;
    }

    /**
     * 
     * @return
     */
    public int getQuantity() {
	return quantity;
    }

    /**
     * 
     * @param goodsquontity
     */
    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }

    /**
     * 
     * @return
     */
    public BigDecimal getCalculatedTax() {
	return calculatedTax;
    }

    /**
     * 
     * @param calculatedTax
     */
    public void setCalculatedTax(BigDecimal calculatedTax) {
	this.calculatedTax = calculatedTax;
    }

    public boolean isImportTax() {
	return importTax;
    }

    public void setImportTax(boolean importTax) {
	this.importTax = importTax;
    }

    @Override
    public String toString() {
	return "TaxInputForm [onlySalesTax=" + onlySalesTax + ", addnlImportTax=" + addnlImportTax + ", importTax=" + importTax + ", exemptTax=" + exemptTax + ", productName=" + productName
		+ ", productPrice=" + productPrice + ", quantity=" + quantity + ", calculatedTax=" + calculatedTax + "]";
    }

}