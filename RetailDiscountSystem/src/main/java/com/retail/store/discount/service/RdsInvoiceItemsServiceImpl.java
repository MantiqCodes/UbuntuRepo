package com.retail.store.discount.service;

import com.retail.store.discount.dto.DTOConverter;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.retail.store.discount.dto.RdsInvoiceItemsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.retail.store.discount.util.EntityWrapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import com.retail.store.discount.dao.RdsInvoiceItemsDAO;

@Service

@Transactional

public class RdsInvoiceItemsServiceImpl implements RdsInvoiceItemsService

{

	@Autowired

	private RdsInvoiceItemsDAO rdsInvoiceItemsDAO;

	private DTOConverter dTOConverter = new DTOConverter();

	@Override

	public EntityWrapper<RdsInvoiceItemsDTO> findRdsInvoiceItemsById(long id)

	{
		EntityWrapper<RdsInvoiceItemsDTO> entityWrapper = new EntityWrapper<RdsInvoiceItemsDTO>();
		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapper.setMessage(" Find RdsInvoiceItems by id=" + id + " Failed");
		RdsInvoiceItemsDTO rdsInvoiceItemsDTO = dTOConverter
				.getRdsInvoiceItemsDTO(rdsInvoiceItemsDAO.findRdsInvoiceItemsById(id));
		if (rdsInvoiceItemsDTO != null && rdsInvoiceItemsDTO.getId() != -1)
		{
			entityWrapper.setHttpStatus(HttpStatus.OK);
			entityWrapper.setT(rdsInvoiceItemsDTO);
			entityWrapper.setMessage(" Find RdsInvoiceItems by id=" + id + " succeeded");
		}
		return entityWrapper;

	}

	@Override

	public EntityWrapper<List<RdsInvoiceItemsDTO>> findAllRdsInvoiceItems1()
	{

		EntityWrapper<List<RdsInvoiceItemsDTO>> entityWrapperList = new EntityWrapper<List<RdsInvoiceItemsDTO>>();
		entityWrapperList.setT(null);
		entityWrapperList.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapperList.setMessage("Entity not found by query ");
		List<RdsInvoiceItemsDTO> rdsInvoiceItemsDTOList = dTOConverter
				.getRdsInvoiceItemsDTOList(rdsInvoiceItemsDAO.findAllRdsInvoiceItems1());
		if (rdsInvoiceItemsDTOList != null && rdsInvoiceItemsDTOList.size() > 0)
		{
			entityWrapperList.setHttpStatus(HttpStatus.OK);
			entityWrapperList.setT(rdsInvoiceItemsDTOList);
			entityWrapperList.setMessage("EntityList  found by Query ");
		}
		return entityWrapperList;

	}

	@Override

	public EntityWrapper<RdsInvoiceItemsDTO> createRdsInvoiceItems(RdsInvoiceItemsDTO rdsInvoiceItemsDTO)

	{

		EntityWrapper<RdsInvoiceItemsDTO> dTOentityWrapper = dTOConverter.getRdsInvoiceItemsDTOEntityWrapper(
				rdsInvoiceItemsDAO.createRdsInvoiceItems(dTOConverter.getRdsInvoiceItems(rdsInvoiceItemsDTO)));
		return dTOentityWrapper;

	}

	@Override

	public EntityWrapper<RdsInvoiceItemsDTO> updateRdsInvoiceItems(RdsInvoiceItemsDTO rdsInvoiceItemsDTO)

	{

		EntityWrapper<RdsInvoiceItemsDTO> dTOentityWrapper = dTOConverter.getRdsInvoiceItemsDTOEntityWrapper(
				rdsInvoiceItemsDAO.updateRdsInvoiceItems(dTOConverter.getRdsInvoiceItems(rdsInvoiceItemsDTO)));
		return dTOentityWrapper;

	}

	@Override

	public EntityWrapper<RdsInvoiceItemsDTO> updateRdsInvoiceItemsByNonEmptyVal(RdsInvoiceItemsDTO rdsInvoiceItemsDTO)

	{

		EntityWrapper<RdsInvoiceItemsDTO> dTOentityWrapper = dTOConverter
				.getRdsInvoiceItemsDTOEntityWrapper(rdsInvoiceItemsDAO
						.updateRdsInvoiceItemsByNonEmptyVal(dTOConverter.getRdsInvoiceItems(rdsInvoiceItemsDTO)));
		return dTOentityWrapper;

	}

	@Override

	public EntityWrapper<Long> deleteRdsInvoiceItems(long id)

	{
		EntityWrapper<Long> entityWrapper = new EntityWrapper<Long>();
		entityWrapper.setT(new Long(-1));
		entityWrapper.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapper.setMessage(" Delete RdsInvoiceItems by id=" + id + " Failed");
		long deletedId = rdsInvoiceItemsDAO.deleteRdsInvoiceItems(id);
		if (deletedId != -1)
		{
			entityWrapper.setHttpStatus(HttpStatus.OK);
			entityWrapper.setT(deletedId);
			entityWrapper.setMessage(" Delete RdsInvoiceItems by id=" + id + " succeeded");
		}
		return entityWrapper;

	}

}
