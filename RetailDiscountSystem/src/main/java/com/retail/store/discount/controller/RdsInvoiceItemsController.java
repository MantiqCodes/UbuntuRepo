package com.retail.store.discount.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.retail.store.discount.util.EntityWrapper;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import com.retail.store.discount.dto.RdsInvoiceItemsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.retail.store.discount.service.RdsInvoiceItemsService;
import org.springframework.http.ResponseEntity;

@RestController

public class RdsInvoiceItemsController

{

	@Autowired

	RdsInvoiceItemsService rdsInvoiceItemsService;

	@RequestMapping(value = "rdsInvoiceItems/{id}", method = RequestMethod.GET, produces = " application/json")

	public ResponseEntity<RdsInvoiceItemsDTO> findRdsInvoiceItemsById(@PathVariable("id") long id,
			UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<RdsInvoiceItemsDTO> responseEntity = new ResponseEntity<RdsInvoiceItemsDTO>(
				new RdsInvoiceItemsDTO(), HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsInvoiceItemsDTO> dtoEntityWrapper = rdsInvoiceItemsService.findRdsInvoiceItemsById(id);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(uriComponentsBuilder.path("/rdsInvoiceItems/")
					.buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsInvoiceItemsDTO>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "rdsInvoiceItems", method = RequestMethod.POST, produces = " application/json", consumes = " application/json")

	public ResponseEntity<RdsInvoiceItemsDTO> createRdsInvoiceItems(@RequestBody RdsInvoiceItemsDTO rdsInvoiceItemsDTO,
			UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<RdsInvoiceItemsDTO> responseEntity = new ResponseEntity<RdsInvoiceItemsDTO>(
				new RdsInvoiceItemsDTO(), HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsInvoiceItemsDTO> dtoEntityWrapper = rdsInvoiceItemsService
				.createRdsInvoiceItems(rdsInvoiceItemsDTO);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(uriComponentsBuilder.path("/rdsInvoiceItems/")
					.buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsInvoiceItemsDTO>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "rdsInvoiceItems", method = RequestMethod.PUT, produces = " application/json", consumes = " application/json")

	public ResponseEntity<RdsInvoiceItemsDTO> updateRdsInvoiceItems(@RequestBody RdsInvoiceItemsDTO rdsInvoiceItemsDTO,
			@PathVariable int id, @PathVariable int isNullChecked, UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<RdsInvoiceItemsDTO> responseEntity = new ResponseEntity<RdsInvoiceItemsDTO>(
				new RdsInvoiceItemsDTO(), HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsInvoiceItemsDTO> dtoEntityWrapper = null;
		if (isNullChecked == 1)
			dtoEntityWrapper = rdsInvoiceItemsService.updateRdsInvoiceItemsByNonEmptyVal(rdsInvoiceItemsDTO);
		else
			dtoEntityWrapper = rdsInvoiceItemsService.updateRdsInvoiceItems(rdsInvoiceItemsDTO);
		if (dtoEntityWrapper != null && dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(uriComponentsBuilder.path("/rdsInvoiceItems/")
					.buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsInvoiceItemsDTO>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "rdsInvoiceItems/{id}", method = RequestMethod.DELETE, produces = " application/json")

	public ResponseEntity<Long> deleteRdsInvoiceItems(@PathVariable("id") long id,
			UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<Long> responseEntity = new ResponseEntity<Long>(new Long(-1), HttpStatus.NOT_FOUND);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<Long> dtoEntityWrapper = rdsInvoiceItemsService.deleteRdsInvoiceItems(id);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT() > -1)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsInvoiceItems/").buildAndExpand(dtoEntityWrapper.getT()).toUri());
			responseEntity = new ResponseEntity<Long>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "findAllRdsInvoiceItems1", method = RequestMethod.GET, produces = " application/json")

	public ResponseEntity<List<RdsInvoiceItemsDTO>> findAllRdsInvoiceItems1(UriComponentsBuilder uriComponentsBuilder)
	{

		ResponseEntity<List<RdsInvoiceItemsDTO>> responseEntity = new ResponseEntity<List<RdsInvoiceItemsDTO>>(
				new ArrayList<RdsInvoiceItemsDTO>(), HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<List<RdsInvoiceItemsDTO>> dtoEntityWrapper = rdsInvoiceItemsService.findAllRdsInvoiceItems1();
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().size() > 0)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsInvoiceItems/findAllRdsInvoiceItems1/").build().toUri());
			responseEntity = new ResponseEntity<List<RdsInvoiceItemsDTO>>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;

	}

}
