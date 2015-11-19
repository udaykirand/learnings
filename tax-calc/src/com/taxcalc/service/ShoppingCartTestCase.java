package com.taxcalc.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.taxcalc.model.TaxInputForm;

import junit.framework.TestCase;

public class ShoppingCartTestCase extends TestCase {
    /**
     * Method purpose : INPUT:
     *
     * Input 1:
     *   1 book at 12.49
     *   1 music CD at 14.99
     *   1 chocolate bar at 0.85
     * Insert calculate tax
     *
     * @param
     * @return void
     */

    public void testScenarioInput_001() {

       
        TaxInputForm inputDataDTO = null;
        List<TaxInputForm> shoppingCartList = new ArrayList<TaxInputForm>();
        //System.out.println("Input 1:");

        // TODO Input 1: 1 book at 12.49
        inputDataDTO = new TaxInputForm();
        inputDataDTO.setGoodsName("Book");
        inputDataDTO.setGoodsquontity(1);
        inputDataDTO.setExemptTax(true);
        inputDataDTO.setGoodsPrice(new BigDecimal(12.49));
        //TODO System.out.println(inputDataDTO.toString());
        //Add to list
        shoppingCartList.add(inputDataDTO);
       
       
        // 1 music CD at 14.99
        inputDataDTO = new TaxInputForm();
        inputDataDTO.setGoodsName("Music CD");
        inputDataDTO.setGoodsquontity(1);
        inputDataDTO.setGoodsPrice(new BigDecimal(14.99));
        inputDataDTO.setDomesticTaxPercentage(true);
        //TODO System.out.println(inputDataDTO.toString());
        //Add to list
        shoppingCartList.add(inputDataDTO);
       

        // 1 chocolate bar at 0.85
        inputDataDTO = new TaxInputForm();
        inputDataDTO.setGoodsName("Chocolate bar");
        inputDataDTO.setGoodsquontity(1);
        inputDataDTO.setGoodsPrice(new BigDecimal(0.85));
        inputDataDTO.setExemptTax(true);
        //TODO System.out.println(inputDataDTO.toString());
        //Add to list
        shoppingCartList.add(inputDataDTO);

        try {
                    // Creating the ShoppingCart
        	ITaxCalculator shopping = new TaxCalculatorImpl();
                   
                    // calculate data
                    shopping.calculateTax(shoppingCartList);

        } catch (Throwable e) {
                    // This operation is not supported hence getting an error
                    System.out.println(e.getLocalizedMessage());
        }

    }

    /**
     * Method purpose :
     *  Input 2:
     *  1 imported box of chocolates at 10.00
     *  1 imported bottle of perfume at 47.50
     *  Insert calculate tax
     *
     * @param
     * @return void
     */

    public void testScenarioInput_002() {

        TaxInputForm inputDataDTO = null;
        List<TaxInputForm> shoppingCartList = new ArrayList<TaxInputForm>();
        //System.out.println("Input 2:");
        // TODO Input 2:
        // 1 imported box of chocolates at 10.00

        inputDataDTO = new TaxInputForm();
        inputDataDTO.setGoodsName("Imported box of chocolates ");
        inputDataDTO.setGoodsquontity(1);
        inputDataDTO.setGoodsPrice(new BigDecimal(10.00));
        inputDataDTO.setAdditionalImportedTaxPercentage(true);
        //TODO System.out.println(inputDataDTO.toString());
        //Add to list
        shoppingCartList.add(inputDataDTO);

        // 1 imported bottle of perfume at 47.50
        inputDataDTO = new TaxInputForm();
        inputDataDTO.setGoodsName("Imported bottle of perfume");
        inputDataDTO.setGoodsquontity(1);
        inputDataDTO.setGoodsPrice(new BigDecimal(47.50));
        inputDataDTO.setAdditionalImportedTaxPercentage(true);
        inputDataDTO.setDomesticTaxPercentage(true);
        //TODO System.out.println(inputDataDTO.toString());
        //Add to List
        shoppingCartList.add(inputDataDTO);
        try {
                    // Creating the ShoppingCart
        	ITaxCalculator shopping = new TaxCalculatorImpl();
                   
                    // calculate data
                    shopping.calculateTax(shoppingCartList);

        } catch (Throwable e) {
                    // This operation is not supported hence getting an error
                    System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Method purpose :
     *  Input 3
     *  1 imported bottle of perfume at 27.99 1 bottle of perfume at 18.99
     *  1 packet of headache pills at 9.75 1 box of imported chocolates at 11.25
     *   Insert calculate tax
     *
     * @param
     * @return void
     */

    public void testScenarioInput_003() {

        TaxInputForm inputDataDTO = null;
        ArrayList<TaxInputForm> shoppingCartList = new ArrayList<TaxInputForm>();
        //System.out.println("Input 3:");
        // TODO Input 3 :
        // 1 imported bottle of perfume at 27.99
        inputDataDTO = new TaxInputForm();
        inputDataDTO.setGoodsName("Imported bottle of perfume");
        inputDataDTO.setGoodsquontity(1);
        inputDataDTO.setGoodsPrice(new BigDecimal(27.99));
        inputDataDTO.setDomesticTaxPercentage(true);
        inputDataDTO.setAdditionalImportedTaxPercentage(true);
        //TODO System.out.println(inputDataDTO.toString());
        //Add to List
        shoppingCartList.add(inputDataDTO);

        // 1 bottle of perfume at 18.99
        inputDataDTO = new TaxInputForm();
        inputDataDTO.setGoodsName("Bottle of perfume");
        inputDataDTO.setGoodsquontity(1);
        inputDataDTO.setGoodsPrice(new BigDecimal(18.99));
        inputDataDTO.setDomesticTaxPercentage(true);
        //TODO System.out.println(inputDataDTO.toString());
        //Add to list
        shoppingCartList.add(inputDataDTO);

        // 1 packet of headache pills at 9.75
        inputDataDTO = new TaxInputForm();
        inputDataDTO.setGoodsName("Packet of headache pills");
        inputDataDTO.setGoodsquontity(1);
        inputDataDTO.setGoodsPrice(new BigDecimal(9.75));
        inputDataDTO.setExemptTax(true);
        //TODO System.out.println(inputDataDTO.toString());
        //Add to list
        shoppingCartList.add(inputDataDTO);

        // 1 box of imported chocolates at 11.25
        inputDataDTO = new TaxInputForm();
        inputDataDTO.setGoodsName("Imported box of chocolates");
        inputDataDTO.setGoodsquontity(1);
        inputDataDTO.setGoodsPrice(new BigDecimal(11.25));
        inputDataDTO.setAdditionalImportedTaxPercentage(true);
        //TODO System.out.println(inputDataDTO.toString());
        //Add to list
        shoppingCartList.add(inputDataDTO);
        try {
                    // Creating the ShoppingCart
        	ITaxCalculator shopping = new TaxCalculatorImpl();
                   
                    // calculate data
                    shopping.calculateTax(shoppingCartList);

        } catch (Throwable e) {
                    // This operation is not supported hence getting an error
                    System.out.println(e.getLocalizedMessage());
        }
    }
   
   
}
