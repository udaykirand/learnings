/**
 * 
 */
package com.taxcalc.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.sun.java_cup.internal.runtime.Symbol;
import com.taxcalc.model.IInputFormBean;
import com.taxcalc.model.TaxInputForm;
import com.taxcalc.util.Constants;
import com.taxcalc.util.Util;

/**
 * @author Uday
 * 
 */
public class SalesTaxCalculatorImpl extends SalesTaxCalculatorBaseImpl {

    /**
     * @param cart
     * @param taxRules
     * @return
     * @throws ShopingCartException
     */
    public List<IInputFormBean> updateCartWithTax(List<IInputFormBean> cart, Properties taxRules) throws ShopingCartException {

	BigDecimal salesTax = null;
	BigDecimal hundread = new BigDecimal(100);
	BigDecimal taxPercentage = null;

	List<IInputFormBean> processedCart = new ArrayList<IInputFormBean>();

	if (!cart.isEmpty()) {
	    Iterator<IInputFormBean> cartIterator = cart.iterator();

	    while (cartIterator.hasNext()) {
		IInputFormBean lineItemDTO = (IInputFormBean) cartIterator.next();
		// System.out.println(inputDataDTO);
		if (lineItemDTO.isExemptTax()) {
		    taxPercentage = new BigDecimal(0);
		} else if (lineItemDTO.isOnlySalesTax() && lineItemDTO.isImportTax()) {
		    taxPercentage = new BigDecimal(taxRules.getProperty(Constants.TAX_AND_EXCISE_DUTY));
		} else if (lineItemDTO.isOnlySalesTax()) {
		    taxPercentage = new BigDecimal(taxRules.getProperty(Constants.ONLY_TAX));
		} else if (lineItemDTO.isImportTax()) {
		    taxPercentage = new BigDecimal(taxRules.getProperty(Constants.IMPORT_DUTY));
		}
		// System.out.println("-----"+taxPercentage+"-----");
		// Calculate Tax
		salesTax = lineItemDTO.getProductPrice().multiply(taxPercentage).divide(hundread);
		// System.out.println("-----"+salesTax+"-----");
		// created new dto list
		processedCart = Util.convertDto(lineItemDTO, salesTax, processedCart);
		// put values into Map
	    } // While

	}
	return processedCart;
    }

    /**
     * Following method is used to display Bill
     * 
     * @param cart
     */
    public void displayBill(List<IInputFormBean> cart, int cartCount) {
	System.out.println("Output# " + cartCount);
	if (cart != null) {
	    Iterator<?> cartIterator = cart.iterator();
	    while (cartIterator.hasNext()) {
		TaxInputForm inputDataDTO = (TaxInputForm) cartIterator.next();

		System.out.println(inputDataDTO.getQuantity() + " " + inputDataDTO.getProductName() + " " + addTaxandPrice(inputDataDTO.getCalculatedTax(), inputDataDTO.getProductPrice()));

	    }
	    System.out.println("Sales Tax : " + totalTax(cart));
	    System.out.println("Total : " + totalPrice(cart));

	}
	System.out.println("=============================================================================");
    }

}
