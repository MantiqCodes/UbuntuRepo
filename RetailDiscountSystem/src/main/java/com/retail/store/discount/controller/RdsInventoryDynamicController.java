package com.retail.store.discount.controller;

import org.springframework.format.annotation.DateTimeFormat;
import com.querydsl.core.BooleanBuilder;
import com.retail.store.discount.model.QRdsInventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import com.retail.store.discount.repo.RdsInventoryRepo;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;
import com.retail.store.discount.model.RdsInventory;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class RdsInventoryDynamicController

{

	@Autowired
	private RdsInventoryRepo rdsInventoryRepo;

	@GetMapping(path = "/getRdsInventory", produces = MediaType.APPLICATION_JSON_VALUE)

	public Page<RdsInventory> getRdsInventory(

			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size,
			@RequestParam(name = "id", required = false) final Long id,
			@RequestParam(name = "qtyOnHand", required = false) final Long qtyOnHand,
			@RequestParam(name = "qtySold", required = false) final Long qtySold,
			@RequestParam(name = "qtyTotal", required = false) final Long qtyTotal,
			@RequestParam(name = "fromEntDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final Date fromEntDate,
			@RequestParam(name = "toEntDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final Date toEntDate)
	{
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if (page != null && page < 0)
			page = 0;
		if (size != null && size < 0)
			size = 10;
		if (id != null)
			booleanBuilder.and(QRdsInventory.rdsInventory.id.eq(id));
		if (qtyOnHand != null)
			booleanBuilder.and(QRdsInventory.rdsInventory.qtyOnHand.eq(qtyOnHand));
		if (qtySold != null)
			booleanBuilder.and(QRdsInventory.rdsInventory.qtySold.eq(qtySold));
		if (qtyTotal != null)
			booleanBuilder.and(QRdsInventory.rdsInventory.qtyTotal.eq(qtyTotal));

		if (fromEntDate != null && toEntDate != null)
			booleanBuilder.and(QRdsInventory.rdsInventory.entDate.between(fromEntDate, toEntDate));

		return rdsInventoryRepo.findAll(booleanBuilder.getValue(),
				PageRequest.of(page, size, Sort.by(Sort.Order.asc("id"))));
	}

}
