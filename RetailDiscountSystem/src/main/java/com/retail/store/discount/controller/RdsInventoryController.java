package com.retail.store.discount.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.retail.store.discount.service.RdsInventoryService;
import com.retail.store.discount.util.EntityWrapper;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import com.retail.store.discount.dto.RdsInventoryDTO;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController

public class RdsInventoryController

{

	@Autowired

	RdsInventoryService rdsInventoryService;

	@RequestMapping(value = "rdsInventory/{id}", method = RequestMethod.GET, produces = " application/json")

	public ResponseEntity<RdsInventoryDTO> findRdsInventoryById(@PathVariable("id") long id,
			UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<RdsInventoryDTO> responseEntity = new ResponseEntity<RdsInventoryDTO>(new RdsInventoryDTO(),
				HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsInventoryDTO> dtoEntityWrapper = rdsInventoryService.findRdsInventoryById(id);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(uriComponentsBuilder.path("/rdsInventory/")
					.buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsInventoryDTO>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "rdsInventory", method = RequestMethod.POST, produces = " application/json", consumes = " application/json")

	public ResponseEntity<RdsInventoryDTO> createRdsInventory(@RequestBody RdsInventoryDTO rdsInventoryDTO,
			UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<RdsInventoryDTO> responseEntity = new ResponseEntity<RdsInventoryDTO>(new RdsInventoryDTO(),
				HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsInventoryDTO> dtoEntityWrapper = rdsInventoryService.createRdsInventory(rdsInventoryDTO);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(uriComponentsBuilder.path("/rdsInventory/")
					.buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsInventoryDTO>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "rdsInventory", method = RequestMethod.PUT, produces = " application/json", consumes = " application/json")

	public ResponseEntity<RdsInventoryDTO> updateRdsInventory(@RequestBody RdsInventoryDTO rdsInventoryDTO,
			@PathVariable int id, @PathVariable int isNullChecked, UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<RdsInventoryDTO> responseEntity = new ResponseEntity<RdsInventoryDTO>(new RdsInventoryDTO(),
				HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<RdsInventoryDTO> dtoEntityWrapper = null;
		if (isNullChecked == 1)
			dtoEntityWrapper = rdsInventoryService.updateRdsInventoryByNonEmptyVal(rdsInventoryDTO);
		else
			dtoEntityWrapper = rdsInventoryService.updateRdsInventory(rdsInventoryDTO);
		if (dtoEntityWrapper != null && dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().getId() > -1)
		{
			httpHeaders.setLocation(uriComponentsBuilder.path("/rdsInventory/")
					.buildAndExpand(dtoEntityWrapper.getT().getId()).toUri());
			responseEntity = new ResponseEntity<RdsInventoryDTO>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "rdsInventory/{id}", method = RequestMethod.DELETE, produces = " application/json")

	public ResponseEntity<Long> deleteRdsInventory(@PathVariable("id") long id,
			UriComponentsBuilder uriComponentsBuilder)
	{
		ResponseEntity<Long> responseEntity = new ResponseEntity<Long>(new Long(-1), HttpStatus.NOT_FOUND);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<Long> dtoEntityWrapper = rdsInventoryService.deleteRdsInventory(id);
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT() > -1)
		{
			httpHeaders.setLocation(
					uriComponentsBuilder.path("/rdsInventory/").buildAndExpand(dtoEntityWrapper.getT()).toUri());
			responseEntity = new ResponseEntity<Long>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;
	}

	@RequestMapping(value = "findAllRdsInventory1", method = RequestMethod.GET, produces = " application/json")

	public ResponseEntity<List<RdsInventoryDTO>> findAllRdsInventory1(UriComponentsBuilder uriComponentsBuilder)
	{

		ResponseEntity<List<RdsInventoryDTO>> responseEntity = new ResponseEntity<List<RdsInventoryDTO>>(
				new ArrayList<RdsInventoryDTO>(), HttpStatus.BAD_REQUEST);
		HttpHeaders httpHeaders = new HttpHeaders();
		EntityWrapper<List<RdsInventoryDTO>> dtoEntityWrapper = rdsInventoryService.findAllRdsInventory1();
		if (dtoEntityWrapper.getT() != null && dtoEntityWrapper.getT().size() > 0)
		{
			httpHeaders.setLocation(uriComponentsBuilder.path("/rdsInventory/findAllRdsInventory1/").build().toUri());
			responseEntity = new ResponseEntity<List<RdsInventoryDTO>>(dtoEntityWrapper.getT(), httpHeaders,
					dtoEntityWrapper.getHttpStatus());
		}
		return responseEntity;

	}

}
