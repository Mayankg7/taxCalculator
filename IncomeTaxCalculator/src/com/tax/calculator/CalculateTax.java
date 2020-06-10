package com.tax.calculator;

import java.util.Map;

public class CalculateTax {

	private static CalculateTax singleTaxInstance = null;

	private CalculateTax() {
	}

	public static CalculateTax getTaxInstance() {

		if (singleTaxInstance == null) {

			singleTaxInstance = new CalculateTax();
		}

		return singleTaxInstance;
	}

	public synchronized double calculateIncomeTax(String countryCode, Double income, Double investmentDecl) {
		CountrySlabRate countryTaxForamt = CountryTaxSlab.getTaxFormat(CountryType.valueOf(countryCode));

		if (investmentDecl < CountrySlabRate.investmentLimit) {
			income = income - investmentDecl;
		} else {
			income = income - CountrySlabRate.investmentLimit;
		}

		Map<Double, Float> taxSlabs = countryTaxForamt.slabRate();

		return taxCalculation(income, taxSlabs, CountrySlabRate.nonTaxableIncome);
	}

	/**
	 * This method calculate the total tax based on tax slab
	 * 
	 * @param income
	 * @param taxSlabs
	 * @return
	 */
	private double taxCalculation(double income, Map<Double, Float> taxSlabs, double nonTaxableIncome) {
		double totalTax = 0, prevSlb = 0;
		double prevRate = 0;
		boolean flag = true;
		if (income <= nonTaxableIncome) {
			return 0.00;
		}
		for (Map.Entry<Double, Float> entry : taxSlabs.entrySet()) {
			flag = true;
			if (income > entry.getKey()) {
				totalTax += (entry.getKey() - prevSlb) * entry.getValue();
				prevSlb = entry.getKey();
				prevRate = entry.getValue();
				continue;
			}
			flag = false;
			totalTax += (income - prevSlb) * entry.getValue();
			break;
		}

		if (flag && income > prevSlb) {
			totalTax += (income - prevSlb) * prevRate;
		}

		return totalTax;

	}

}
