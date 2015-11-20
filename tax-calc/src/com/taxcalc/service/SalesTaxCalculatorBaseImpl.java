package com.taxcalc.service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.taxcalc.model.IInputFormBean;
import com.taxcalc.model.TaxInputForm;
import com.taxcalc.service.impl.ISalesTaxCalculator;

/**
 * 
 * @author Uday
 */
public abstract class SalesTaxCalculatorBaseImpl implements ISalesTaxCalculator {

    /*
     * (non-Javadoc)
     * 
     * @see com.taxcalc.service.impl.ISalesTaxCalculator#calculateTaxAndPrint(java.util.List, java.util.Properties)
     */
    public void calculateTaxAndPrint(List<IInputFormBean> cart, Properties taxRules, int cartCount) throws ShopingCartException {
	List<IInputFormBean> processedCart = this.updateCartWithTax(cart, taxRules);
	this.displayBill(processedCart, cartCount);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.taxcalc.service.impl.ISalesTaxCalculator#displayBill(java.util.List)
     */
    public abstract void displayBill(List<IInputFormBean> processedCart, int cartCount);

    /*
     * (non-Javadoc)
     * 
     * @see com.taxcalc.service.impl.ISalesTaxCalculator#updateCartWithTax(java.util.List, java.util.Properties)
     */
    public abstract List<IInputFormBean> updateCartWithTax(List<IInputFormBean> cart, Properties taxRules) throws ShopingCartException;

    /**
     * @param tax
     * @param price
     * @return
     */
    protected BigDecimal addTaxandPrice(BigDecimal tax, BigDecimal price) {
	BigDecimal addtax = tax.add(price);
	return roundOff(addtax);
    }

    /**
     * Method used to calculate total price
     *
     * @param cart
     * @return
     */
    protected BigDecimal totalPrice(List<IInputFormBean> cart) {

	BigDecimal total = new BigDecimal(0);

	if (cart != null) {
	    Iterator<IInputFormBean> cartIterator = cart.iterator();

	    while (cartIterator.hasNext()) {
		TaxInputForm inputDataDTO = (TaxInputForm) cartIterator.next();
		total = total.add(inputDataDTO.getProductPrice().add(inputDataDTO.getCalculatedTax()));

	    }

	}
	total = this.roundOff(total);

	return total;
    }

    /**
     * Following method is used to calculate total tax
     *
     * @param cart
     * @return
     */
    protected BigDecimal totalTax(List<IInputFormBean> cart) {

	BigDecimal total = new BigDecimal(0);

	if (cart != null) {
	    Iterator<IInputFormBean> cartIterator = cart.iterator();

	    while (cartIterator.hasNext()) {
		TaxInputForm inputDataDTO = (TaxInputForm) cartIterator.next();
		total = total.add(inputDataDTO.getCalculatedTax());
	    }

	    total = roundOff(total);
	}
	return total;
    }

    /**
     * 
     * @param value
     * @return
     */

    protected BigDecimal roundOff(BigDecimal value) {
	value = value.divide(ROUND_FACTOR);
	value = new BigDecimal(Math.ceil(value.doubleValue()));
	value = value.multiply(ROUND_FACTOR);
	return value;
    }

}
