package com.tax.calculator;

public class TaxCalculator {
	public static void main(String aa[]) {
		double taxDeducted = CalculateTax.getTaxInstance().calculateIncomeTax("IND", 550000.00, 75000.00);
		System.out.println(Math.ceil(taxDeducted));
	}
}
