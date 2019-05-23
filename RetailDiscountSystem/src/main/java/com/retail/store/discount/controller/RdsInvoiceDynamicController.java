package com.retail.store.discount.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.BooleanBuilder;
import com.retail.store.discount.model.QRdsInvoice;
import com.retail.store.discount.model.RdsInvoice;
import com.retail.store.discount.repo.RdsInvoiceRepo;

@RestController
public class RdsInvoiceDynamicController

{

	@Autowired
	private RdsInvoiceRepo rdsInvoiceRepo;

	@GetMapping(path = "/getRdsInvoice", produces = MediaType.APPLICATION_JSON_VALUE)

	public Page<RdsInvoice> getRdsInvoice(

			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size,
			@RequestParam(name = "id", required = false) final Long id,
			@RequestParam(name = "entryCount", required = false) final Long entryCount,
			@RequestParam(name = "docPrice", required = false) final Double docPrice,
			@RequestParam(name = "docPriceAfterDiscount", required = false) final Double docPriceAfterDiscount,
			@RequestParam(name = "docDiscount", required = false) final Double docDiscount,
			@RequestParam(name = "discountBase", required = false) final String discountBase,
			@RequestParam(name = "fromDocDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final Date fromDocDate,
			@RequestParam(name = "toDocDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final Date toDocDate)
	{
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if (page != null && page < 0)
			page = 0;
		if (size != null && size < 0)
			size = 10;
		if (id != null)
			booleanBuilder.and(QRdsInvoice.rdsInvoice.id.eq(id));
		if (entryCount != null)
			booleanBuilder.and(QRdsInvoice.rdsInvoice.entryCount.eq(entryCount));
		if (docPrice != null)
			booleanBuilder.and(QRdsInvoice.rdsInvoice.docPrice.eq(docPrice));
		if (docPriceAfterDiscount != null)
			booleanBuilder.and(QRdsInvoice.rdsInvoice.docPriceAfterDiscount.eq(docPriceAfterDiscount));
		if (docDiscount != null)
			booleanBuilder.and(QRdsInvoice.rdsInvoice.docDiscount.eq(docDiscount));
		if (discountBase != null && !discountBase.isEmpty())
			booleanBuilder.and(QRdsInvoice.rdsInvoice.discountBase.eq(discountBase));

		if (fromDocDate != null && toDocDate != null)
			booleanBuilder.and(QRdsInvoice.rdsInvoice.docDate.between(fromDocDate, toDocDate));

		return rdsInvoiceRepo.findAll(booleanBuilder.getValue(),
				PageRequest.of(page, size, Sort.by(Sort.Order.asc("id"))));
	}

}
