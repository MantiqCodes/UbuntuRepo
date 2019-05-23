package com.retail.store.discount.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.retail.store.discount.dto.DTOConverter;
import com.retail.store.discount.dto.RdsInvoiceDTO;
import com.retail.store.discount.model.RdsInvoice;
import com.retail.store.discount.repo.RdsInvoiceRepo;
import com.retail.store.discount.repo.RdsItemsRepo;
import com.retail.store.discount.repo.RdsUsersRepo;
import com.retail.store.discount.service.RdsInvoiceService;
import com.retail.store.discount.util.DISCOUNT_BASE;
import com.retail.store.discount.util.EntityWrapper;
import com.retail.store.discount.util.UserTypes;

@RestController

public class DiscountController
{
	@Autowired
	RdsInvoiceRepo rdsInvoiceRepo;

	@Autowired

	RdsInvoiceService rdsInvoiceService;

	@RequestMapping(value = "invDisc/{id}", method = RequestMethod.GET, produces = " application/json")

	public Double findRdsInvoiceById(@PathVariable("id") long id, UriComponentsBuilder uriComponentsBuilder)
	{
		Double discount = 0.0;

		EntityWrapper<RdsInvoiceDTO> dtoEntityWrapper = rdsInvoiceService.findRdsInvoiceById(id);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			DTOConverter c = new DTOConverter();
			RdsInvoice rdsInvoice = c.getRdsInvoice(dtoEntityWrapper.getT());
			long daysInTwoYears = 365 * 2;
			Date now = new Date();
			long diffMillis = now.getTime() - rdsInvoice.getRdsUsersCustomer().getActiveDate().getTime();
			long diffDays = diffMillis / (1000 * 60 * 60 * 24);
			if (UserTypes.EMPLOYEE.value().equals(rdsInvoice.getRdsUsersCustomer().getUserType()))
			{
				discount = rdsInvoice.getDocPrice() * 30 / 100;
				rdsInvoice.setDiscountBase(DISCOUNT_BASE.EMPLOYEE_BASED_DISCOUNT.value());
				rdsInvoice.setDocDiscount(discount);
				rdsInvoice.setDocPriceAfterDiscount(rdsInvoice.getDocPrice() - discount);
			} else if (UserTypes.AFFILIATE.value().equals(rdsInvoice.getRdsUsersCustomer().getUserType()))
			{
				discount = rdsInvoice.getDocPrice() * 10 / 100;
				rdsInvoice.setDiscountBase(DISCOUNT_BASE.EMPLOYEE_BASED_DISCOUNT.value());
				rdsInvoice.setDocDiscount(discount);
				rdsInvoice.setDocPriceAfterDiscount(rdsInvoice.getDocPrice() - discount);

			} else if (UserTypes.CUSTOMER.value().equals(rdsInvoice.getRdsUsersCustomer().getUserType()))
			{

				if (diffDays >= daysInTwoYears || rdsInvoice.getDocPrice() > 100)
				{
					discount = rdsInvoice.getDocPrice() * 5 / 100;
					rdsInvoice.setDiscountBase(DISCOUNT_BASE.EMPLOYEE_BASED_DISCOUNT.value());
					rdsInvoice.setDocDiscount(discount);
					rdsInvoice.setDocPriceAfterDiscount(rdsInvoice.getDocPrice() - discount);

				}
			}

		}
		return discount;
	}
}
