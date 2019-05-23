package com.retail.store.discount.model;

import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryEntity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;

@QueryEntity
@Entity

@Table(name = "RDS_INVOICE_ITEMS")

@SequenceGenerator(name = "RDS_INVOICE_ITEMS_SEQ_Gen", sequenceName = "RDS_INVOICE_ITEMS_SEQ", allocationSize = 1)

@NamedQueries({
		@NamedQuery(name = "findAllRdsInvoiceItems1", query = "SELECT rInvcItms FROM RdsInvoiceItems rInvcItms ") })
public class RdsInvoiceItems implements Serializable

{

	private static final long serialVersionUID = -3331142390476374046L;

	@JsonFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")
	@DateTimeFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")

	private long id;

	private RdsItems rdsItemsItem;

	private RdsInvoice rdsInvoiceInvoice;

	private double qty;

	private double rate;

	private double itemTotal;

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RDS_INVOICE_ITEMS_SEQ_Gen")

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INVOICE_ID", referencedColumnName = "ID")

	public RdsInvoice getRdsInvoiceInvoice()

	{

		return this.rdsInvoiceInvoice;

	}

	public void setRdsInvoiceInvoice(RdsInvoice rdsInvoiceInvoice)

	{

		this.rdsInvoiceInvoice = rdsInvoiceInvoice;

	}

	@Column(name = "QTY")

	public double getQty()

	{

		return this.qty;

	}

	public void setQty(double qty)

	{

		this.qty = qty;

	}

	@Column(name = "RATE")

	public double getRate()

	{

		return this.rate;

	}

	public void setRate(double rate)

	{

		this.rate = rate;

	}

	@Column(name = "ITEM_TOTAL")

	public double getItemTotal()

	{

		return this.itemTotal;

	}

	public void setItemTotal(double itemTotal)

	{

		this.itemTotal = itemTotal;

	}
}
