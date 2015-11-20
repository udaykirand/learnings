/**
 * 
 */
package com.taxcalc.service;

import java.util.List;
import java.util.Properties;

import com.taxcalc.model.IInputFormBean;
import com.taxcalc.service.impl.ISalesTaxCalculator;
import com.taxcalc.service.impl.ITaxCalculator;

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
    public void prepareBillForCart(List<IInputFormBean> cart, Properties taxRules, int cartCount) {
	ISalesTaxCalculator calculator = CalculatorFactory.getInstance();
	try {
	    calculator.calculateTaxAndPrint(cart, taxRules, cartCount);
	} catch (ShopingCartException e) {
	    e.printStackTrace();
	}

    }

}
