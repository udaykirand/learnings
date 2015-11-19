/**
 * 
 */
package com.taxcalc.service;

import java.util.List;

import com.taxcalc.model.IInputFormBean;

/**
 * @author Uday
 *
 */
public interface ITaxCalculator {
	 /**
     * Calculate Shopping Cart Bill Users calculate records Bill (Once bill gets
     * generate user can’t add, edit, remove or calculate records.
     */
    public void calculateTax(List<IInputFormBean> shopingCartInputDTOList) ;
}
