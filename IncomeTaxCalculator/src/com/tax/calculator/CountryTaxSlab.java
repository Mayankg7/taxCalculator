package com.tax.calculator;

import java.util.HashMap;
import java.util.Map;

public class CountryTaxSlab {

	static Map<CountryType, Map<Double, Float>> countryTaxSlabMap = new HashMap<>();

	public static CountrySlabRate getTaxFormat(CountryType countryCode) {
		CountrySlabRate country = null;
		switch (countryCode) {
		case IND:
			country = new INDIASlabRate(countryCode);
			break;

		case USA:
			country = new USASlabRate(countryCode);
			break;

		case CHINA:
			country = new CHINASlabRate(countryCode);
			break;

		case UK:
			country = new UKSlabRate(countryCode);
			break;

		default:
			// throw exception Country Not Found
			break;
		}
		return country;
	}
}
