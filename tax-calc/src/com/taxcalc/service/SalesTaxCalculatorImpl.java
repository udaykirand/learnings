/**
 * 
 */
package com.taxcalc.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Uday
 * 
 */
public class SalesTaxCalculatorImpl extends SalesTaxCalculatorBaseImpl {
	/**
	 * @author Vaquar Khan Following method is used to calculate tax 1) Basic
	 *         sales tax is applicable at a rate of 10% on all goods, 2) Except
	 *         books, food, and medical products that are exempt. 3) Import duty
	 *         is an additional sales tax applicable on all imported goods at a
	 *         rate of 5%, with no exemptions.
	 * 
	 *         When I purchase items I receive a receipt which lists the name of
	 *         all the items and their price (including tax),
	 * 
	 *         finishing with the total cost of the items, and the total amounts
	 *         of sales taxes paid. The rounding rules for sales tax are that
	 *         for a tax rate of n%, a shelf price of p contains (np/100 rounded
	 *         up to the nearest 0.05) amount of sales tax.
	 * 
	 * @param shopingCartInputDTOList
	 * @return
	 * @throws ShopingCartException
	 */
	public List<InputDataDTO> calculateTaxPercentage(
			List<?> shopingCartInputDTOList) throws ShopingCartException {

		BigDecimal salesTax = null;
		BigDecimal hundread = new BigDecimal(ShoppingCartconstantsIfc.HUNDREAD);
		BigDecimal taxPercentage = null;

		List<InputDataDTO> newShopingCartInputDTOList = new ArrayList<InputDataDTO>();

		if (shopingCartInputDTOList != null) {
			// Create Iterator
			Iterator<?> shopingCartInputDTOListItr = shopingCartInputDTOList
					.iterator();

			while (shopingCartInputDTOListItr.hasNext()) {
				InputDataDTO inputDataDTO = (InputDataDTO) shopingCartInputDTOListItr
						.next();

				if (inputDataDTO.isExemptTax()) {
					taxPercentage = new BigDecimal(
							Util.readProperties(ShoppingCartconstantsIfc.EXEMPT));
				} else if (inputDataDTO.isDomesticTaxPercentage()
						&& inputDataDTO.isAdditionalImportedTaxPercentage()) {
					taxPercentage = new BigDecimal(
							Util.readProperties(ShoppingCartconstantsIfc.BASIC_SALES_TAX_AND_IMPORT_DUTY));
				} else if (inputDataDTO.isDomesticTaxPercentage()) {
					taxPercentage = new BigDecimal(
							Util.readProperties(ShoppingCartconstantsIfc.BASIC_SALES_TAX));
				} else if (inputDataDTO.isAdditionalImportedTaxPercentage()) {
					taxPercentage = new BigDecimal(
							Util.readProperties(ShoppingCartconstantsIfc.IMPORT_DUTY));
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
	 * @param shopingCartInputDTOList
	 */
	public void displayBill(List<?> shopingCartInputDTOList) {

		if (shopingCartInputDTOList != null) {
			Iterator<?> shopingCartInputDTOListItr = shopingCartInputDTOList
					.iterator();

			// System.out.println(" \t \t \t :SHOPPING BILL: ");
			// System.out.println("\n \n ");
			System.out
					.println("=============================================================================");
			System.out.println("Quantity " + "\t" + "\t" + "\t" + " Name "
					+ "\t" + "\t" + "\t" + " Price ");
			System.out
					.println("=============================================================================");

			while (shopingCartInputDTOListItr.hasNext()) {
				InputDataDTO inputDataDTO = (InputDataDTO) shopingCartInputDTOListItr
						.next();

				System.out.println(inputDataDTO.getGoodsquontity()
						+ "\t"
						+ "\t"
						+ inputDataDTO.getGoodsName()
						+ "\t"
						+ "\t"
						+ ":"
						+ addTaxandPrice(
								inputDataDTO.getCalculateTaxPercentage(),
								inputDataDTO.getGoodsPrice()));

			}// While

			System.out
					.println("----------------------------------------------------------------------------");
			System.out.println("Sales Tax : "
					+ totalTax(shopingCartInputDTOList));
			System.out
					.println("Total : " + totalPrice(shopingCartInputDTOList));

		}// end of if
		System.out
				.println("=============================================================================");
	}

}
