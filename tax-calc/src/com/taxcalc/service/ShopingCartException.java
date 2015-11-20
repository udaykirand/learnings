package com.taxcalc.service;

/**
 * ShopingCartException use for throw error if any issue found in ShopingCart project
 * 
 * @author Uday
 *
 */
public class ShopingCartException extends Exception {

    String mistake;

    // Default constructor - initializes instance variable to unknown
    public ShopingCartException() {
	super(); // call superclass constructor
	mistake = "unknown";
    }

    // Constructor receives some kind of message that is saved in an instance
    // variable.
    public ShopingCartException(String err) {
	super(err); // call super class constructor
	mistake = err; // save message
    }

    // public method, callable by exception catcher. It returns the error
    // message.
    public String getError() {
	return mistake;
    }
}