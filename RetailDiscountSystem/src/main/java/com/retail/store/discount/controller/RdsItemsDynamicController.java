package com.retail.store.discount.controller;

import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.retail.store.discount.model.RdsItems;
import org.springframework.web.bind.annotation.RestController;

import com.retail.store.discount.repo.RdsItemsRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.retail.store.discount.model.QRdsItems;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class RdsItemsDynamicController

{

	@Autowired
	private RdsItemsRepo rdsItemsRepo;

	@GetMapping(path = "/getRdsItems", produces = MediaType.APPLICATION_JSON_VALUE)

	public Page<RdsItems> getRdsItems(

			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size,
			@RequestParam(name = "id", required = false) final Long id,
			@RequestParam(name = "name", required = false) final String name,
			@RequestParam(name = "description", required = false) final String description,
			@RequestParam(name = "price", required = false) final Double price,
			@RequestParam(name = "category", required = false) final String category,
			@RequestParam(name = "unitOfMeasure", required = false) final String unitOfMeasure)
	{
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if (page != null && page < 0)
			page = 0;
		if (size != null && size < 0)
			size = 10;
		if (id != null)
			booleanBuilder.and(QRdsItems.rdsItems.id.eq(id));
		if (name != null && !name.isEmpty())
			booleanBuilder.and(QRdsItems.rdsItems.name.eq(name));
		if (description != null && !description.isEmpty())
			booleanBuilder.and(QRdsItems.rdsItems.description.eq(description));
		if (price != null)
			booleanBuilder.and(QRdsItems.rdsItems.price.eq(price));
		if (category != null && !category.isEmpty())
			booleanBuilder.and(QRdsItems.rdsItems.category.eq(category));
		if (unitOfMeasure != null && !unitOfMeasure.isEmpty())
			booleanBuilder.and(QRdsItems.rdsItems.unitOfMeasure.eq(unitOfMeasure));

		return rdsItemsRepo.findAll(booleanBuilder.getValue(),
				PageRequest.of(page, size, Sort.by(Sort.Order.asc("id"))));
	}

}
