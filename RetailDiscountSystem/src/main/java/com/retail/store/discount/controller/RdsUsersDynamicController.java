package com.retail.store.discount.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.retail.store.discount.model.QRdsUsers;
import com.retail.store.discount.model.RdsUsers;
import com.retail.store.discount.service.RdsUsersRepoService;

@RestController
public class RdsUsersDynamicController

{

	@Autowired
	private RdsUsersRepoService usersRepoService;

	@GetMapping(path = "/rdsUsers/{id}")
	public RdsUsers getUserById(@PathVariable long id)
	{
		return usersRepoService.findRdsUsersById(id).get();
	}

	@GetMapping("/rdsUsers")
	public List<RdsUsers> getAllRdsUsers()
	{
		return this.usersRepoService.findAll();
	}

	// @PutMapping(value = "/updateRdsUsers/{id}")
	// public ResponseEntity<RdsUsers> updateEmployee (
	// @PathVariable("id") Long id,
	//// @Valid
	// @RequestBody RdsUsers rdsUsers)
	// {
	// RdsUsers u= this.usersRepoService.updateRdsUsers(rdsUsers);
	// return new ResponseEntity<RdsUsers>(u, HttpStatus.OK);
	// }

	@GetMapping(path = "/getRdsUsers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

	public Page<RdsUsers> getRdsUsers(

			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size,
			@RequestParam(name = "id", required = false) final Long id,
			@RequestParam(name = "firstName", required = false) final String firstName,
			@RequestParam(name = "lastName", required = false) final String lastName,
			@RequestParam(name = "username", required = false) final String username,
			@RequestParam(name = "password", required = false) final String password,
			@RequestParam(name = "email", required = false) final String email,
			@RequestParam(name = "address", required = false) final String address,
			@RequestParam(name = "userType", required = false) final String userType,
			@RequestParam(name = "phone", required = false) final String phone,
			@RequestParam(name = "city", required = false) final String city,
			@RequestParam(name = "country", required = false) final String country,
			@RequestParam(name = "isActive", required = false) final Integer isActive,
			@RequestParam(name = "fromActiveDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final Date fromActiveDate,
			@RequestParam(name = "toActiveDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final Date toActiveDate,
			@RequestParam(name = "fromEntDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final Date fromEntDate,
			@RequestParam(name = "toEntDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final Date toEntDate)
	{
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if (page != null && page < 0)
			page = 0;
		if (size != null && size < 0)
			size = 10;
		if (id != null)
			booleanBuilder.and(QRdsUsers.rdsUsers.id.eq(id));
		if (firstName != null && !firstName.isEmpty())
			booleanBuilder.and(QRdsUsers.rdsUsers.firstName.eq(firstName));
		if (lastName != null && !lastName.isEmpty())
			booleanBuilder.and(QRdsUsers.rdsUsers.lastName.eq(lastName));
		if (username != null && !username.isEmpty())
			booleanBuilder.and(QRdsUsers.rdsUsers.username.eq(username));
		if (password != null && !password.isEmpty())
			booleanBuilder.and(QRdsUsers.rdsUsers.password.eq(password));
		if (email != null && !email.isEmpty())
			booleanBuilder.and(QRdsUsers.rdsUsers.email.eq(email));
		if (address != null && !address.isEmpty())
			booleanBuilder.and(QRdsUsers.rdsUsers.address.eq(address));
		if (userType != null && !userType.isEmpty())
			booleanBuilder.and(QRdsUsers.rdsUsers.userType.eq(userType));
		if (phone != null && !phone.isEmpty())
			booleanBuilder.and(QRdsUsers.rdsUsers.phone.eq(phone));
		if (city != null && !city.isEmpty())
			booleanBuilder.and(QRdsUsers.rdsUsers.city.eq(city));
		if (country != null && !country.isEmpty())
			booleanBuilder.and(QRdsUsers.rdsUsers.country.eq(country));
		if (isActive != null)
			booleanBuilder.and(QRdsUsers.rdsUsers.isActive.eq(isActive));

		if (fromActiveDate != null && toActiveDate != null)
			booleanBuilder.and(QRdsUsers.rdsUsers.activeDate.between(fromActiveDate, toActiveDate));
		if (fromEntDate != null && toEntDate != null)
			booleanBuilder.and(QRdsUsers.rdsUsers.entDate.between(fromEntDate, toEntDate));

		// return rdsUsersRepo.findAll(booleanBuilder.getValue(),
		// PageRequest.of(page,size, Sort.by(Sort.Order.asc("id"))));
		return usersRepoService.findAllPaginated(booleanBuilder.getValue(), page, size, Order.ASC, "id");
	}

}
