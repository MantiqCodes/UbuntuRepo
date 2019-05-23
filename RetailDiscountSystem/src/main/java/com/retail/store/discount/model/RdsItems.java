package com.retail.store.discount.model;

import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.NamedQuery;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryEntity;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;

@QueryEntity
@Entity

@Table(name = "RDS_ITEMS")

@SequenceGenerator(name = "RDS_ITEMS_SEQ_Gen", sequenceName = "RDS_ITEMS_SEQ", allocationSize = 1)

@NamedQueries({ @NamedQuery(name = "findAllRdsItems1", query = "SELECT rItms FROM RdsItems rItms ") })
public class RdsItems implements Serializable

{

	private static final long serialVersionUID = -5853900104170411050L;

	@JsonFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")
	@DateTimeFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")

	private long id;

	private String name;

	private String description;

	private double price;

	private String category;

	private String unitOfMeasure;

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RDS_ITEMS_SEQ_Gen")

	@Column(name = "ID")

	public long getId()

	{

		return this.id;

	}

	public void setId(long id)

	{

		this.id = id;

	}

	@Column(name = "NAME", nullable = false)

	public String getName()

	{

		return this.name;

	}

	public void setName(String name)

	{

		this.name = name;

	}

	@Column(name = "DESCRIPTION")

	public String getDescription()

	{

		return this.description;

	}

	public void setDescription(String description)

	{

		this.description = description;

	}

	@Column(name = "PRICE")

	public double getPrice()

	{

		return this.price;

	}

	public void setPrice(double price)

	{

		this.price = price;

	}

	@Column(name = "CATEGORY")

	public String getCategory()

	{

		return this.category;

	}

	public void setCategory(String category)

	{

		this.category = category;

	}

	@Column(name = "UNIT_OF_MEASURE")

	public String getUnitOfMeasure()

	{

		return this.unitOfMeasure;

	}

	public void setUnitOfMeasure(String unitOfMeasure)

	{

		this.unitOfMeasure = unitOfMeasure;

	}
}
