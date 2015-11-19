package com.taxcalc.start;

import java.io.File;
import java.util.List;

import com.taxcalc.model.IInputFormBean;
import com.taxcalc.service.ITaxCalculator;
import com.taxcalc.service.InputProcessor;
import com.taxcalc.service.TaxCalculatorImpl;

/**
 * @author Uday
 * 
 */
public class Execute {

	public static void main(String[] args) {

		try {
			File dir = new File("input");
			File[] directoryListing = dir.listFiles();
			if (directoryListing != null) {
				for (File file : directoryListing) {
					List<IInputFormBean> cart = InputProcessor.prepareModel(file);
					ITaxCalculator shopping = new TaxCalculatorImpl();
					shopping.calculateTax(cart);
				}
			}
		} catch (Exception e) {
			System.err.println("Exception occured " + e);
			e.printStackTrace();
		}

	}

}
