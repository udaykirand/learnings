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
     * Following method will use for isAddnlImportTax
     * 
     * @return
     */
    public boolean isAddnlImportTax();

    /**
     * Following method will use for setAddnlImportTax
     * 
     * @param addnlImportTax
     */
    public void setAddnlImportTax(boolean addnlImportTax);

    /**
     * Following method will use for isOnlySalesTax
     * 
     * @return isOnlySalesTax
     */

    public boolean isOnlySalesTax();

    /**
     * Following method will use for isOnlySalesTax
     * 
     * @param isOnlySalesTax
     */
    public void setOnlySalesTax(boolean isOnlySalesTax);

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
     * Following method will use for getProductName
     * 
     * @return ProductName
     */
    public String getProductName();

    /**
     * Following method will use for setProductName
     * 
     * @param productName
     */
    public void setProductName(String productName);

    /**
     * Following method will use for getProductPrice
     * 
     * @return productPrice
     */
    public BigDecimal getProductPrice();

    /**
     * Following method will use for setProductPrice
     * 
     * @param productPrice
     */
    public void setProductPrice(BigDecimal productPrice);

    /**
     * Following method will use for getQuantity
     * 
     * @return
     */
    public int getQuantity();

    /**
     * Following method will use for setQuantity
     * 
     * @param quantity
     */
    public void setQuantity(int quantity);

    /**
     * Following method will use for getCalculatedTax
     * 
     * @return
     */
    public BigDecimal getCalculatedTax();

    /**
     * Following method will use for setCalculatedTax
     * 
     * @param calculatedTax
     */
    public void setCalculatedTax(BigDecimal calculatedTax);
    
    /**
     * Following method will use for importTax
     * 
     * @return
     */
    public boolean isImportTax();

    /**
     * Following method will use for importTax
     * 
     * @param importTax
     */
    public void setImportTax(boolean importTax);


}