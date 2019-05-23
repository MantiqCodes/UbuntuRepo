package com.retail.store.discount.controller;

import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import com.retail.store.discount.model.RdsInvoiceItems;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.retail.store.discount.model.QRdsInvoiceItems;
import org.springframework.web.bind.annotation.RestController;

import com.retail.store.discount.repo.RdsInvoiceItemsRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class RdsInvoiceItemsDynamicController

{

	@Autowired
	private RdsInvoiceItemsRepo rdsInvoiceItemsRepo;

	@GetMapping(path = "/getRdsInvoiceItems", produces = MediaType.APPLICATION_JSON_VALUE)

	public Page<RdsInvoiceItems> getRdsInvoiceItems(

			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size,
			@RequestParam(name = "id", required = false) final Long id,
			@RequestParam(name = "qty", required = false) final Double qty,
			@RequestParam(name = "rate", required = false) final Double rate,
			@RequestParam(name = "itemTotal", required = false) final Double itemTotal)
	{
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if (page != null && page < 0)
			page = 0;
		if (size != null && size < 0)
			size = 10;
		if (id != null)
			booleanBuilder.and(QRdsInvoiceItems.rdsInvoiceItems.id.eq(id));
		if (qty != null)
			booleanBuilder.and(QRdsInvoiceItems.rdsInvoiceItems.qty.eq(qty));
		if (rate != null)
			booleanBuilder.and(QRdsInvoiceItems.rdsInvoiceItems.rate.eq(rate));
		if (itemTotal != null)
			booleanBuilder.and(QRdsInvoiceItems.rdsInvoiceItems.itemTotal.eq(itemTotal));

		return rdsInvoiceItemsRepo.findAll(booleanBuilder.getValue(),
				PageRequest.of(page, size, Sort.by(Sort.Order.asc("id"))));
	}

}
