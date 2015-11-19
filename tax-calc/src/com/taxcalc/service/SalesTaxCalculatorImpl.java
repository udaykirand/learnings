/**
 * 
 */
package com.taxcalc.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.taxcalc.model.IInputFormBean;
import com.taxcalc.model.TaxInputForm;

/**
 * @author Uday
 * 
 */
public class SalesTaxCalculatorImpl extends SalesTaxCalculatorBaseImpl {
	/**
	 * @author Uday Following method is used to calculate tax 1) Basic sales tax
	 *         is applicable at a rate of 10% on all goods, 2) Except books,
	 *         food, and medical products that are exempt. 3) Import duty is an
	 *         additional sales tax applicable on all imported goods at a rate
	 *         of 5%, with no exemptions.
	 * 
	 *         When I purchase items I receive a receipt which lists the name of
	 *         all the items and their price (including tax),
	 * 
	 *         finishing with the total cost of the items, and the total amounts
	 *         of sales taxes paid. The rounding rules for sales tax are that
	 *         for a tax rate of n%, a shelf price of p contains (np/100 rounded
	 *         up to the nearest 0.05) amount of sales tax.
	 * 
	 * @param cart
	 * @return
	 * @throws ShopingCartException
	 */
	public List<IInputFormBean> calculateTaxPercentage(
			List<IInputFormBean> cart) throws ShopingCartException {

		BigDecimal salesTax = null;
		BigDecimal hundread = new BigDecimal(Constants.HUNDREAD);
		BigDecimal taxPercentage = null;

		List<IInputFormBean> newShopingCartInputDTOList = new ArrayList<IInputFormBean>();

		if (cart != null) {
			// Create Iterator
			Iterator<IInputFormBean> cartIterator = cart
					.iterator();

			while (cartIterator.hasNext()) {
				IInputFormBean inputDataDTO = (IInputFormBean) cartIterator
						.next();

				if (inputDataDTO.isExemptTax()) {
					taxPercentage = new BigDecimal(
							Util.readProperties(Constants.EXEMPT));
				} else if (inputDataDTO.isDomesticTaxPercentage()
						&& inputDataDTO.isAdditionalImportedTaxPercentage()) {
					taxPercentage = new BigDecimal(
							Util.readProperties(Constants.BASIC_SALES_TAX_AND_IMPORT_DUTY));
				} else if (inputDataDTO.isDomesticTaxPercentage()) {
					taxPercentage = new BigDecimal(
							Util.readProperties(Constants.BASIC_SALES_TAX));
				} else if (inputDataDTO.isAdditionalImportedTaxPercentage()) {
					taxPercentage = new BigDecimal(
							Util.readProperties(Constants.IMPORT_DUTY));
				}

				// Calculate Tax
				salesTax = inputDataDTO.getGoodsPrice().multiply(taxPercentage)
						.divide(hundread);
				// created new dto list
				newShopingCartInputDTOList = Util.convertDto(inputDataDTO,
						salesTax, newShopingCartInputDTOList);
				// put values into Map
			}// While

		}
		return newShopingCartInputDTOList;
	}

	/**
	 * Following method is used to display Bill
	 * 
	 * @param cart
	 */
	public void displayBill(List<IInputFormBean> cart) {

		if (cart != null) {
			Iterator<?> shopingCartInputDTOListItr = cart
					.iterator();

			while (shopingCartInputDTOListItr.hasNext()) {
				TaxInputForm inputDataDTO = (TaxInputForm) shopingCartInputDTOListItr
						.next();

				System.out.println(inputDataDTO.getGoodsquontity()+" "
						+ inputDataDTO.getGoodsName()+" "
						+ addTaxandPrice(
								inputDataDTO.getCalculateTaxPercentage(),
								inputDataDTO.getGoodsPrice()));

			}
			System.out.println("Sales Tax : "
					+ totalTax(cart));
			System.out
					.println("Total : " + totalPrice(cart));

		}// end of if
		System.out
				.println("=============================================================================");
	}

}
