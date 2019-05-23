package com.retail.store.discount.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.retail.store.discount.dto.RdsUsersDTO;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RdsInvoiceDTO

{
	@JsonFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")
	@DateTimeFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")

	private long id;

	private long entryCount;

	private double docPrice;

	private double docPriceAfterDiscount;

	private double docDiscount;

	private String discountBase;

	private RdsUsersDTO rdsUsersCustomerDTO;

	private Date docDate;

	public long getId()

	{

		return this.id;

	}

	public void setId(long id)

	{

		this.id = id;

	}

	public long getEntryCount()

	{

		return this.entryCount;

	}

	public void setEntryCount(long entryCount)

	{

		this.entryCount = entryCount;

	}

	public double getDocPrice()

	{

		return this.docPrice;

	}

	public void setDocPrice(double docPrice)

	{

		this.docPrice = docPrice;

	}

	public double getDocPriceAfterDiscount()

	{

		return this.docPriceAfterDiscount;

	}

	public void setDocPriceAfterDiscount(double docPriceAfterDiscount)

	{

		this.docPriceAfterDiscount = docPriceAfterDiscount;

	}

	public double getDocDiscount()

	{

		return this.docDiscount;

	}

	public void setDocDiscount(double docDiscount)

	{

		this.docDiscount = docDiscount;

	}

	public String getDiscountBase()

	{

		return this.discountBase;

	}

	public void setDiscountBase(String discountBase)

	{

		this.discountBase = discountBase;

	}

	public RdsUsersDTO getRdsUsersCustomerDTO()

	{

		return this.rdsUsersCustomerDTO;

	}

	public void setRdsUsersCustomerDTO(RdsUsersDTO rdsUsersCustomerDTO)

	{

		this.rdsUsersCustomerDTO = rdsUsersCustomerDTO;

	}

	public Date getDocDate()

	{

		return this.docDate;

	}

	public void setDocDate(Date docDate)

	{

		this.docDate = docDate;

	}
}
