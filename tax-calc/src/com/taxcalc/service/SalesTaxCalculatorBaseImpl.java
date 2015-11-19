package com.taxcalc.service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import com.taxcalc.model.IInputFormBean;
import com.taxcalc.model.TaxInputForm;


/**
 * Following class in base class its contain few abstract methods
 * incase fure we need to make any changes , we can write new implementation .
 * =============================================================================
 * 1) Basic sales tax is applicable at a rate of 10% on all goods,
 * 2) Except books, food, and medical products that are exempt.
 * 3) Import duty is an  additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.
 *
 * When I purchase items I receive a receipt which lists the name of all the items and their price (including tax),
 *
 * finishing with the total cost of the items, and the total amounts of sales
 * taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a
 * shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of
 * sales tax.
 *
 * Write an application that prints out the receipt details for these shopping baskets...
 *
 * INPUT:
 *
 * Input 1: 1 book at 12.49 1 music CD at 14.99 1 chocolate bar at 0.85
 *
 * Input 2: 1 im@author Udayported box of chocolates at 10.00 1 imported bottle of perfume
 * at 47.50
 *
 * Input 3: 1 imported bottle of perfume at 27.99 1 bottle of perfume at 18.99 1
 * packet of headache pills at 9.75 1 box of imported chocolates at 11.25
 *
 * OUTPUT
 *
 * Output 1: 1 book: 12.49 1 music CD: 16.49 1 chocolate bar: 0.85 Sales Taxes:
 * 1.50 Total: 29.83
 *
 * Output 2: 1 imported box of chocolates: 10.50 1 imported bottle of perfume:
 * 54.65 Sales Taxes: 7.65 Total: 65.15
 *
 * Output 3: 1 imported bottle of perfume: 32.19 1 bottle of perfume: 20.89 1
 * packet of headache pills: 9.75 1 imported box of chocolates: 11.85 Sales
 * Taxes: 6.70 Total: 74.68
 * =============================================================================
 *
 * @author Uday
 */
public abstract class SalesTaxCalculatorBaseImpl implements
		ISalesTaxCalculator {  //ROUND_FACTOR
    private static final BigDecimal ROUND_FACTOR = new BigDecimal("0.05");

    /**
     * Calculate Shopping Cart Bill Users calculate records Bill
     * (Once bill gets generate user can’t add, edit, remove or calculate records)
     * @throws ShopingCartException
     */
    public void calculateTax(List<IInputFormBean> cart) throws ShopingCartException {

        // Calculate records
        List<IInputFormBean> processedCart = this.calculateTaxPercentage(cart);
        this.displayBill(processedCart);

    }

    /**
     * Following method is used to display Bill
     * May be in future requirement gets change and want to display result in different format thats why
     * I have made it abstract
     *
     * @param processedCart
     */
    public abstract void displayBill(List<IInputFormBean> processedCart);

    /**
     * Following method is used to calculate tax
     *  1) Basic sales tax is applicable at a rate of 10% on all goods,
     *  2) Except books, food, and medical products that are exempt.
     *  3) Import duty is an additional sales
     * tax applicable on all imported goods at a rate of 5%, with no exemptions.
     *
     * When I purchase items I receive a receipt which lists the name of all the
     * items and their price (including tax),
     *
     * finishing with the total cost of the items, and the total amounts of
     * sales taxes paid. The rounding rules for sales tax are that for a tax
     * rate of n%, a shelf price of p contains (np/100 rounded up to the nearest
     * 0.05) amount of sales tax.
     *
     * @param shopingCartInputDTOList
     * @return
     * @throws ShopingCartException
     */
    public abstract List<IInputFormBean> calculateTaxPercentage(
                    List<IInputFormBean> shopingCartInputDTOList) throws ShopingCartException;

    /**
     * Following method is used for add tax with price
     *
     * @param calculateTaxPercentage
     * @param goodsPrice
     * @return
     */
    protected BigDecimal addTaxandPrice(BigDecimal calculateTaxPercentage,
                    BigDecimal goodsPrice) {
        BigDecimal addtax = calculateTaxPercentage.add(goodsPrice);
        addtax = roundOff(addtax);
        return addtax;
    }

    /**
     * Following method is used to calculate total price
     *
     * @param shopingCartInputDTOList
     * @return
     */
    protected BigDecimal totalPrice(List<?> shopingCartInputDTOList) {

        BigDecimal total = new BigDecimal(0);

        if (shopingCartInputDTOList != null) {
                    Iterator<?> shopingCartInputDTOListItr = shopingCartInputDTOList
                                            .iterator();

                    while (shopingCartInputDTOListItr.hasNext()) {
                                TaxInputForm inputDataDTO = (TaxInputForm) shopingCartInputDTOListItr
                                                        .next();
                                total = total.add(inputDataDTO.getGoodsPrice().add(inputDataDTO.getCalculateTaxPercentage()));

                    }// end of while

        }
        total = this.roundOff(total);

        return total;
    }

    /**
     * Following method is used to calculate total tax
     *
     * @param shopingCartInputDTOList
     * @return
     */
    protected BigDecimal totalTax(List<?> shopingCartInputDTOList) {

        BigDecimal total = new BigDecimal(0);

        if (shopingCartInputDTOList != null) {
                    Iterator<?> shopingCartInputDTOListItr = shopingCartInputDTOList.iterator();

                    while (shopingCartInputDTOListItr.hasNext()) {
                                TaxInputForm inputDataDTO = (TaxInputForm) shopingCartInputDTOListItr.next();
                                total = total.add(inputDataDTO.getCalculateTaxPercentage());
                    }// end of while

                    total = roundOff(total);
        }
        return total;
    }

    /**
     * JDK 1.4 Following method is used for round off up to .05 Round of 0.05
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
