package com.retail.store.discount.util;

public enum DISCOUNT_BASE
{
	EMPLOYEE_BASED_DISCOUNT("Employee Based Discount"), AFFILIATE_BASED_DISCOUNT(
			"Affiliate Based Discount"), CUSTOMER_BASED_DISCOUNT(
					"Customer Based Discount"), NO_DISCOUNT_APPLIED("No discount applied")

	;
	private String dicountBase;

	private DISCOUNT_BASE(String discountBase)
	{
		this.dicountBase = discountBase;
	}

	public String value()
	{
		return this.dicountBase;
	}

}
