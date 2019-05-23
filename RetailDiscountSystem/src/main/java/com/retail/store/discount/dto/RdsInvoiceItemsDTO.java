package com.retail.store.discount.dto;

import com.retail.store.discount.dto.RdsItemsDTO;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.retail.store.discount.dto.RdsInvoiceDTO;

public class RdsInvoiceItemsDTO

{
	@JsonFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")
	@DateTimeFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")

	private long id;

	private RdsItemsDTO rdsItemsItemDTO;

	private RdsInvoiceDTO rdsInvoiceInvoiceDTO;

	private double qty;

	private double rate;

	private double itemTotal;

	public long getId()

	{

		return this.id;

	}

	public void setId(long id)

	{

		this.id = id;

	}

	public RdsItemsDTO getRdsItemsItemDTO()

	{

		return this.rdsItemsItemDTO;

	}

	public void setRdsItemsItemDTO(RdsItemsDTO rdsItemsItemDTO)

	{

		this.rdsItemsItemDTO = rdsItemsItemDTO;

	}

	public RdsInvoiceDTO getRdsInvoiceInvoiceDTO()

	{

		return this.rdsInvoiceInvoiceDTO;

	}

	public void setRdsInvoiceInvoiceDTO(RdsInvoiceDTO rdsInvoiceInvoiceDTO)

	{

		this.rdsInvoiceInvoiceDTO = rdsInvoiceInvoiceDTO;

	}

	public double getQty()

	{

		return this.qty;

	}

	public void setQty(double qty)

	{

		this.qty = qty;

	}

	public double getRate()

	{

		return this.rate;

	}

	public void setRate(double rate)

	{

		this.rate = rate;

	}

	public double getItemTotal()

	{

		return this.itemTotal;

	}

	public void setItemTotal(double itemTotal)

	{

		this.itemTotal = itemTotal;

	}
}
