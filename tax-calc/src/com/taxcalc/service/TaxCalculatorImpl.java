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
public class TaxCalculatorImpl implements ITaxCalculator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.taxcalc.service.ITaxCalculator#calculateTax(java.util.List)
	 */
	/**
	 * This is only point of contact of outside world Calculate Shopping Cart
	 * Bill Users calculate records Bill (Once bill gets generate user can’t
	 * add, edit, remove or calculate records.
	 * 
	 * @throws ShopingCartException
	 */
	public void calculateTax(List<IInputFormBean> cart) {
		ISalesTaxCalculator calculator =  CartFactory.getInstance();
		try {
			calculator.calculateTax(cart);
		} catch (ShopingCartException e) {
			e.printStackTrace();
		}

	}

}
