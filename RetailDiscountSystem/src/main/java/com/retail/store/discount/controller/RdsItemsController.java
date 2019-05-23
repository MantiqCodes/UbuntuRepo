package com.retail.store.discount.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.retail.store.discount.service.RdsItemsService;
import com.retail.store.discount.dto.RdsItemsDTO;
import com.retail.store.discount.util.EntityWrapper;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController

public class RdsItemsController

{

	@Autowired

	RdsItemsService rdsItemsService;

	@RequestMapping(value = "rdsItems/{id}", method = RequestMethod.GET, produces = " application/json")

	public ResponseEntity<RdsItemsDTO> findRdsItemsById(@PathVariable("id") long id,
			UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<RdsItemsDTO> responseEntity = new ResponseEntity<RdsItemsDTO>(new RdsItemsDTO(),
				HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsItemsDTO> dtoEntityWrapper = rdsItemsService.findRdsItemsById(id);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsItems/").buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsItemsDTO>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "rdsItems", method = RequestMethod.POST, produces = " application/json", consumes = " application/json")

	public ResponseEntity<RdsItemsDTO> createRdsItems(@RequestBody RdsItemsDTO rdsItemsDTO,
			UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<RdsItemsDTO> responseEntity = new ResponseEntity<RdsItemsDTO>(new RdsItemsDTO(),
				HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsItemsDTO> dtoEntityWrapper = rdsItemsService.createRdsItems(rdsItemsDTO);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsItems/").buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsItemsDTO>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "rdsItems", method = RequestMethod.PUT, produces = " application/json", consumes = " application/json")

	public ResponseEntity<RdsItemsDTO> updateRdsItems(@RequestBody RdsItemsDTO rdsItemsDTO, @PathVariable int id,
			@PathVariable int isNullChecked, UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<RdsItemsDTO> responseEntity = new ResponseEntity<RdsItemsDTO>(new RdsItemsDTO(),
				HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsItemsDTO> dtoEntityWrapper = null;
		if (isNullChecked == 1)
			dtoEntityWrapper = rdsItemsService.updateRdsItemsByNonEmptyVal(rdsItemsDTO);
		else
			dtoEntityWrapper = rdsItemsService.updateRdsItems(rdsItemsDTO);
		if (dtoEntityWrapper != null && dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsItems/").buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsItemsDTO>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "rdsItems/{id}", method = RequestMethod.DELETE, produces = " application/json")

	public ResponseEntity<Long> deleteRdsItems(@PathVariable("id") long id, UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<Long> responseEntity = new ResponseEntity<Long>(new Long(-1), HttpStatus.NOT_FOUND);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<Long> dtoEntityWrapper = rdsItemsService.deleteRdsItems(id);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT() > -1)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsItems/").buildAndExpand(dtoEntityWrapper.getT()).toUri());
			responseEntity = new ResponseEntity<Long>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "findAllRdsItems1", method = RequestMethod.GET, produces = " application/json")

	public ResponseEntity<List<RdsItemsDTO>> findAllRdsItems1(UriComponentsBuilder uriComponentsBuilder)
	{

		ResponseEntity<List<RdsItemsDTO>> responseEntity = new ResponseEntity<List<RdsItemsDTO>>(
				new ArrayList<RdsItemsDTO>(), HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<List<RdsItemsDTO>> dtoEntityWrapper = rdsItemsService.findAllRdsItems1();
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().size() > 0)
		{
			httpHeaders.setLocation(uriComponentsBuilder.path("/rdsItems/findAllRdsItems1/").build().toUri());
			responseEntity = new ResponseEntity<List<RdsItemsDTO>>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;

	}

}
