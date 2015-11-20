/**
 * 
 */
package com.taxcalc.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

import com.taxcalc.model.IInputFormBean;
import com.taxcalc.service.ShopingCartException;

/**
 * 
 * following class is single point of entry of outside world
 * 
 * @author Uday
 *
 */
public interface ISalesTaxCalculator {

    static final BigDecimal ROUND_FACTOR = new BigDecimal("0.05");

    
    /**
     * @param cart
     * @param taxRules
     * @param cartCount 
     * @throws ShopingCartException
     */
    public void calculateTaxAndPrint(List<IInputFormBean> cart, Properties taxRules, int cartCount) throws ShopingCartException;

    /**
     * Method to display the bill from processed cart
     * 
     * @param processedCart
     */
    public void displayBill(List<IInputFormBean> processedCart, int cartCount);

    /**
     * Updates given cart item with tax using taxRules and generates processedCart
     * 
     * @param cart
     * @return processedCart
     * @throws ShopingCartException
     */
    public List<IInputFormBean> updateCartWithTax(List<IInputFormBean> cart, Properties taxRules) throws ShopingCartException;
}
