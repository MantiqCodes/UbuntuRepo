package com.retail.store.discount.model;

import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import java.util.Date;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.SequenceGenerator;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querydsl.core.annotations.QueryEntity;
import com.retail.store.discount.util.DISCOUNT_BASE;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;

@QueryEntity
@Entity

@Table(name = "RDS_INVOICE")

@SequenceGenerator(name = "RDS_INVOICE_SEQ_Gen", sequenceName = "RDS_INVOICE_SEQ", allocationSize = 1)

@NamedQueries({ @NamedQuery(name = "findAllRdsInvoice1", query = "SELECT rInvc FROM RdsInvoice rInvc ") })
public class RdsInvoice implements Serializable

{

	private static final long serialVersionUID = -2160098842376122878L;

	@JsonFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")
	@DateTimeFormat(pattern = "EEE, d MMM yyyy HH:mm:ss z")

	private long id;

	private long entryCount;

	private double docPrice;

	private double docPriceAfterDiscount;

	private double docDiscount;

	private String discountBase;

	private RdsUsers rdsUsersCustomer;

	private Date docDate;

	public RdsInvoice()
	{
		this.setDiscountBase(DISCOUNT_BASE.NO_DISCOUNT_APPLIED.value());
	}

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RDS_INVOICE_SEQ_Gen")

	@Column(name = "ID")

	public long getId()

	{

		return this.id;

	}

	public void setId(long id)

	{

		this.id = id;

	}

	@Column(name = "ENTRY_COUNT")

	public long getEntryCount()

	{

		return this.entryCount;

	}

	public void setEntryCount(long entryCount)

	{

		this.entryCount = entryCount;

	}

	@Column(name = "DOC_PRICE")

	public double getDocPrice()

	{

		return this.docPrice;

	}

	public void setDocPrice(double docPrice)

	{

		this.docPrice = docPrice;

	}

	@Column(name = "DOC_PRICE_AFTER_DISCOUNT")

	public double getDocPriceAfterDiscount()

	{

		return this.docPriceAfterDiscount;

	}

	public void setDocPriceAfterDiscount(double docPriceAfterDiscount)

	{

		this.docPriceAfterDiscount = docPriceAfterDiscount;

	}

	@Column(name = "DOC_DISCOUNT")

	public double getDocDiscount()

	{

		return this.docDiscount;

	}

	public void setDocDiscount(double docDiscount)

	{

		this.docDiscount = docDiscount;

	}

	@Column(name = "DISCOUNT_BASE")

	public String getDiscountBase()

	{

		return this.discountBase;

	}

	public void setDiscountBase(String discountBase)

	{

		this.discountBase = discountBase;

	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")

	public RdsUsers getRdsUsersCustomer()

	{

		return this.rdsUsersCustomer;

	}

	public void setRdsUsersCustomer(RdsUsers rdsUsersCustomer)

	{

		this.rdsUsersCustomer = rdsUsersCustomer;

	}

	@Column(name = "DOC_DATE")

	@Temporal(TemporalType.TIMESTAMP)

	public Date getDocDate()

	{

		return this.docDate;

	}

	public void setDocDate(Date docDate)

	{

		this.docDate = docDate;

	}
}
