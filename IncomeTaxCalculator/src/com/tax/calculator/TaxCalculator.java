package com.tax.calculator;

public class TaxCalculator{
	public static void main(String aa[]) {
		double taxDeducted = CalculateTax.getTaxInstance().calculateIncomeTax("IND", 700000.00, 0.00);
		System.out.println(Math.ceil(taxDeducted));
	}

}
