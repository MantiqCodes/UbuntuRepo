package com.retail.store.discount.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.retail.store.discount.dto.RdsUsersDTO;
import com.retail.store.discount.service.RdsUsersService;
import com.retail.store.discount.util.EntityWrapper;

@RestController

public class RdsUsersController

{

	@Autowired

	RdsUsersService rdsUsersService;

	@RequestMapping(value = "rdsUsers/{id}", method = RequestMethod.GET, produces = " application/json")

	public ResponseEntity<RdsUsersDTO> findRdsUsersById(@PathVariable("id") long id,
			UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<RdsUsersDTO> responseEntity = new ResponseEntity<RdsUsersDTO>(new RdsUsersDTO(),
				HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsUsersDTO> dtoEntityWrapper = rdsUsersService.findRdsUsersById(id);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsUsers/").buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsUsersDTO>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "rdsUsers", method = RequestMethod.POST, produces = " application/json", consumes = " application/json")

	public ResponseEntity<RdsUsersDTO> createRdsUsers(@RequestBody RdsUsersDTO rdsUsersDTO,
			UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<RdsUsersDTO> responseEntity = new ResponseEntity<RdsUsersDTO>(new RdsUsersDTO(),
				HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsUsersDTO> dtoEntityWrapper = rdsUsersService.createRdsUsers(rdsUsersDTO);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsUsers/").buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsUsersDTO>(dtoEntityWrapper.getT(), httpHeaders,HttpStatus.CREATED);
		}
		return responseEntity;
	}

	@RequestMapping(value = "rdsUsers", method = RequestMethod.PUT, produces = " application/json", consumes = " application/json")

	public ResponseEntity<RdsUsersDTO> updateRdsUsers(@RequestBody RdsUsersDTO rdsUsersDTO, @PathVariable int id,
			@PathVariable int isNullChecked, UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<RdsUsersDTO> responseEntity = new ResponseEntity<RdsUsersDTO>(new RdsUsersDTO(),
				HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsUsersDTO> dtoEntityWrapper = null;
		if (isNullChecked == 1)
			dtoEntityWrapper = rdsUsersService.updateRdsUsersByNonEmptyVal(rdsUsersDTO);
		else
			dtoEntityWrapper = rdsUsersService.updateRdsUsers(rdsUsersDTO);
		if (dtoEntityWrapper != null && dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsUsers/").buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsUsersDTO>(dtoEntityWrapper.getT(), httpHeaders,
					HttpStatus.OK);
		}
		return responseEntity;
	}

	@RequestMapping(value = "rdsUsers/{id}", method = RequestMethod.DELETE, produces = " application/json")

	public ResponseEntity<Long> deleteRdsUsers(@PathVariable("id") long id, UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<Long> responseEntity = new ResponseEntity<Long>(new Long(-1), HttpStatus.NOT_FOUND);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<Long> dtoEntityWrapper = rdsUsersService.deleteRdsUsers(id);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT() > -1)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsUsers/").buildAndExpand(dtoEntityWrapper.getT()).toUri());
			responseEntity = new ResponseEntity<Long>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "findAllRdsUsers1", method = RequestMethod.GET, produces = " application/json")

	public ResponseEntity<List<RdsUsersDTO>> findAllRdsUsers1(UriComponentsBuilder uriComponentsBuilder)
	{

		ResponseEntity<List<RdsUsersDTO>> responseEntity = new ResponseEntity<List<RdsUsersDTO>>(
				new ArrayList<RdsUsersDTO>(), HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<List<RdsUsersDTO>> dtoEntityWrapper = rdsUsersService.findAllRdsUsers1();
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().size() > 0)
		{
			httpHeaders.setLocation(uriComponentsBuilder.path("/rdsUsers/findAllRdsUsers1/").build().toUri());
			responseEntity = new ResponseEntity<List<RdsUsersDTO>>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;

	}

	@RequestMapping(value = "findUniqueRdsUsersBYUsername2/{username}", method = RequestMethod.GET, produces = " application/json")

	public ResponseEntity<RdsUsersDTO> findUniqueRdsUsersBYUsername2(@PathVariable("username") String username,
			UriComponentsBuilder uriComponentsBuilder)
	{

		ResponseEntity<RdsUsersDTO> responseEntity = new ResponseEntity<RdsUsersDTO>(new RdsUsersDTO(),
				HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsUsersDTO> dtoEntityWrapper = rdsUsersService.findUniqueRdsUsersBYUsername2(username);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsUsers/").buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsUsersDTO>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;

	}

	@RequestMapping(value = "findUniqueRdsUsersBYEmail4/{email}", method = RequestMethod.GET, produces = " application/json")

	public ResponseEntity<RdsUsersDTO> findUniqueRdsUsersBYEmail4(@PathVariable("email") String email,
			UriComponentsBuilder uriComponentsBuilder)
	{

		ResponseEntity<RdsUsersDTO> responseEntity = new ResponseEntity<RdsUsersDTO>(new RdsUsersDTO(),
				HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsUsersDTO> dtoEntityWrapper = rdsUsersService.findUniqueRdsUsersBYEmail4(email);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsUsers/").buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsUsersDTO>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;

	}

}
