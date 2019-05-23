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

import com.retail.store.discount.dto.RdsInvoiceDTO;
import com.retail.store.discount.service.RdsInvoiceService;
import com.retail.store.discount.util.EntityWrapper;

@RestController

public class RdsInvoiceController

{

	@Autowired

	RdsInvoiceService rdsInvoiceService;

	@RequestMapping(value = "rdsInvoice/{id}", method = RequestMethod.GET, produces = " application/json")

	public ResponseEntity<RdsInvoiceDTO> findRdsInvoiceById(@PathVariable("id") long id,
			UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<RdsInvoiceDTO> responseEntity = new ResponseEntity<RdsInvoiceDTO>(new RdsInvoiceDTO(),
				HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsInvoiceDTO> dtoEntityWrapper = rdsInvoiceService.findRdsInvoiceById(id);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsInvoice/").buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsInvoiceDTO>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "rdsInvoice", method = RequestMethod.POST, produces = " application/json", consumes = " application/json")

	public ResponseEntity<RdsInvoiceDTO> createRdsInvoice(@RequestBody RdsInvoiceDTO rdsInvoiceDTO,
			UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<RdsInvoiceDTO> responseEntity = new ResponseEntity<RdsInvoiceDTO>(new RdsInvoiceDTO(),
				HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsInvoiceDTO> dtoEntityWrapper = rdsInvoiceService.createRdsInvoice(rdsInvoiceDTO);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsInvoice/").buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsInvoiceDTO>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "rdsInvoice", method = RequestMethod.PUT, produces = " application/json", consumes = " application/json")

	public ResponseEntity<RdsInvoiceDTO> updateRdsInvoice(@RequestBody RdsInvoiceDTO rdsInvoiceDTO,
			@PathVariable int id, @PathVariable int isNullChecked, UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<RdsInvoiceDTO> responseEntity = new ResponseEntity<RdsInvoiceDTO>(new RdsInvoiceDTO(),
				HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsInvoiceDTO> dtoEntityWrapper = null;
		if (isNullChecked == 1)
			dtoEntityWrapper = rdsInvoiceService.updateRdsInvoiceByNonEmptyVal(rdsInvoiceDTO);
		else
			dtoEntityWrapper = rdsInvoiceService.updateRdsInvoice(rdsInvoiceDTO);
		if (dtoEntityWrapper != null && dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsInvoice/").buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsInvoiceDTO>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "rdsInvoice/{id}", method = RequestMethod.DELETE, produces = " application/json")

	public ResponseEntity<Long> deleteRdsInvoice(@PathVariable("id") long id, UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<Long> responseEntity = new ResponseEntity<Long>(new Long(-1), HttpStatus.NOT_FOUND);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<Long> dtoEntityWrapper = rdsInvoiceService.deleteRdsInvoice(id);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT() > -1)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsInvoice/").buildAndExpand(dtoEntityWrapper.getT()).toUri());
			responseEntity = new ResponseEntity<Long>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "findAllRdsInvoice1", method = RequestMethod.GET, produces = " application/json")

	public ResponseEntity<List<RdsInvoiceDTO>> findAllRdsInvoice1(UriComponentsBuilder uriComponentsBuilder)
	{

		ResponseEntity<List<RdsInvoiceDTO>> responseEntity = new ResponseEntity<List<RdsInvoiceDTO>>(
				new ArrayList<RdsInvoiceDTO>(), HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<List<RdsInvoiceDTO>> dtoEntityWrapper = rdsInvoiceService.findAllRdsInvoice1();
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().size() > 0)
		{
			httpHeaders.setLocation(uriComponentsBuilder.path("/rdsInvoice/findAllRdsInvoice1/").build().toUri());
			responseEntity = new ResponseEntity<List<RdsInvoiceDTO>>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;

	}

}
