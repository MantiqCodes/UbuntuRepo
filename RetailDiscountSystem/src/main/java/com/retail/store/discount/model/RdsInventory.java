package com.retail.store.discount.model;

import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.GenerationType;
import java.util.Date;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.SequenceGenerator;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryEntity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;

@QueryEntity
@Entity

@Table(name = "RDS_INVENTORY")

@SequenceGenerator(name = "RDS_INVENTORY_SEQ_Gen", sequenceName = "RDS_INVENTORY_SEQ", allocationSize = 1)

@NamedQueries({ @NamedQuery(name = "findAllRdsInventory1", query = "SELECT rInvntry FROM RdsInventory rInvntry ") })
public class RdsInventory implements Serializable

{
	@JsonFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")
	@DateTimeFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")

	private static final long serialVersionUID = -6226307168766731048L;

	private long id;

	private RdsItems rdsItemsItem;

	private long qtyOnHand;

	private long qtySold;

	private long qtyTotal;

	private Date entDate;

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RDS_INVENTORY_SEQ_Gen")

	@Column(name = "ID")

	public long getId()

	{

		return this.id;

	}

	public void setId(long id)

	{

		this.id = id;

	}

	@OneToOne
	@JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")

	public RdsItems getRdsItemsItem()

	{

		return this.rdsItemsItem;

	}

	public void setRdsItemsItem(RdsItems rdsItemsItem)

	{

		this.rdsItemsItem = rdsItemsItem;

	}

	@Column(name = "QTY_ON_HAND")

	public long getQtyOnHand()

	{

		return this.qtyOnHand;

	}

	public void setQtyOnHand(long qtyOnHand)

	{

		this.qtyOnHand = qtyOnHand;

	}

	@Column(name = "QTY_SOLD")

	public long getQtySold()

	{

		return this.qtySold;

	}

	public void setQtySold(long qtySold)

	{

		this.qtySold = qtySold;

	}

	@Column(name = "QTY_TOTAL")

	public long getQtyTotal()

	{

		return this.qtyTotal;

	}

	public void setQtyTotal(long qtyTotal)

	{

		this.qtyTotal = qtyTotal;

	}

	@Column(name = "ENT_DATE")

	@Temporal(TemporalType.TIMESTAMP)

	public Date getEntDate()

	{

		return this.entDate;

	}

	public void setEntDate(Date entDate)

	{

		this.entDate = entDate;

	}
}
