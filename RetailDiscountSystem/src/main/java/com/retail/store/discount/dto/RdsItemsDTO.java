package com.retail.store.discount.dto;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RdsItemsDTO

{
	@JsonFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")
	@DateTimeFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")

	private long id;

	private String name;

	private String description;

	private double price;

	private String category;

	private String unitOfMeasure;

	public long getId()

	{

		return this.id;

	}

	public void setId(long id)

	{

		this.id = id;

	}

	public String getName()

	{

		return this.name;

	}

	public void setName(String name)

	{

		this.name = name;

	}

	public String getDescription()

	{

		return this.description;

	}

	public void setDescription(String description)

	{

		this.description = description;

	}

	public double getPrice()

	{

		return this.price;

	}

	public void setPrice(double price)

	{

		this.price = price;

	}

	public String getCategory()

	{

		return this.category;

	}

	public void setCategory(String category)

	{

		this.category = category;

	}

	public String getUnitOfMeasure()

	{

		return this.unitOfMeasure;

	}

	public void setUnitOfMeasure(String unitOfMeasure)

	{

		this.unitOfMeasure = unitOfMeasure;

	}
}
