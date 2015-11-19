package com.taxcalc.model;

public class Sample {
	public static void main(String[] sa){
	String s = "1 imported bottle of perfume at 47.50";
	System.out.println(s.substring(2, s.indexOf("at")));
}}
