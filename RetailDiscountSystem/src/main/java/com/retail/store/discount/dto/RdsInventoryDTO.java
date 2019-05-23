package com.retail.store.discount.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.retail.store.discount.dto.RdsItemsDTO;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RdsInventoryDTO

{
	@JsonFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")
	@DateTimeFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")

	private long id;

	private RdsItemsDTO rdsItemsItemDTO;

	private long qtyOnHand;

	private long qtySold;

	private long qtyTotal;

	private Date entDate;

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

	public long getQtyOnHand()

	{

		return this.qtyOnHand;

	}

	public void setQtyOnHand(long qtyOnHand)

	{

		this.qtyOnHand = qtyOnHand;

	}

	public long getQtySold()

	{

		return this.qtySold;

	}

	public void setQtySold(long qtySold)

	{

		this.qtySold = qtySold;

	}

	public long getQtyTotal()

	{

		return this.qtyTotal;

	}

	public void setQtyTotal(long qtyTotal)

	{

		this.qtyTotal = qtyTotal;

	}

	public Date getEntDate()

	{

		return this.entDate;

	}

	public void setEntDate(Date entDate)

	{

		this.entDate = entDate;

	}
}
