/**
 * 
 */
package com.taxcalc.service;

import java.util.List;

import com.taxcalc.model.IInputFormBean;
import com.taxcalc.model.TaxInputForm;

/**
 * @author Uday
 *
 */
public interface ISalesTaxCalculator {
	/**
     * following class is single point of entry of outside world
     * @param cart
     * @throws ShopingCartException
     */
    public void calculateTax(List<IInputFormBean> cart) throws ShopingCartException;
    /**
     * Displaying result as per user requirement
     * @param cart
     */
    public  void displayBill(List<IInputFormBean> cart);
    /**
     * calculate tax
     * @param cart
     * @return
     * @throws ShopingCartException
     */
    public  List<IInputFormBean> calculateTaxPercentage(List<IInputFormBean> cart) throws ShopingCartException ;
}
