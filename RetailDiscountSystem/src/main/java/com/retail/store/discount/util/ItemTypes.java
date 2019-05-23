package com.retail.store.discount.util;

public enum ItemTypes
{
	GROCERY("Grocery"), NON_GROCERY("Non-Grocery")

	;
	private String itemType;

	private ItemTypes(String itemsType)
	{
		this.itemType = itemsType;
	}

	public String value()
	{

		return this.itemType;

	}

}
