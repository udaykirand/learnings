package com.taxcalc.service;

/**
 * This is Static Factory for Object creation. Currently its creating only
 * ServiceTaxCalculatorImpl object but if in future required to decorate any
 * object then factory would help it modify it easily.
 * 
 * @author Uday
 * 
 */
public class CartFactory {
	private static ISalesTaxCalculator taxCalc = null;

	// made class immutable
	private CartFactory() {
	}

	/**
	 * following method will return instance of BO Currently single thread is
	 * accessing instance so no need synchronization
	 * 
	 * @param type
	 * @return
	 */
	public static ISalesTaxCalculator getInstance() {
		if (taxCalc == null) {
			taxCalc = new SalesTaxCalculatorImpl();
		}
		return taxCalc;
	}
}
