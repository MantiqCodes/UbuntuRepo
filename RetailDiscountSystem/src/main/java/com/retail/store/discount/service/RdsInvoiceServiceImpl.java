package com.retail.store.discount.service;

import com.retail.store.discount.dto.DTOConverter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.retail.store.discount.dto.RdsInvoiceDTO;
import com.retail.store.discount.util.EntityWrapper;
import org.springframework.http.HttpStatus;
import com.retail.store.discount.dao.RdsInvoiceDAO;

@Service

@Transactional

public class RdsInvoiceServiceImpl implements RdsInvoiceService

{

	@Autowired

	private RdsInvoiceDAO rdsInvoiceDAO;

	private DTOConverter dTOConverter = new DTOConverter();

	@Override

	public EntityWrapper<RdsInvoiceDTO> findRdsInvoiceById(long id)

	{
		EntityWrapper<RdsInvoiceDTO> entityWrapper = new EntityWrapper<RdsInvoiceDTO>();
		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapper.setMessage(" Find RdsInvoice by id=" + id + " Failed");
		RdsInvoiceDTO rdsInvoiceDTO = dTOConverter.getRdsInvoiceDTO(rdsInvoiceDAO.findRdsInvoiceById(id));
		if (rdsInvoiceDTO != null && rdsInvoiceDTO.getId() != -1)
		{
			entityWrapper.setHttpStatus(HttpStatus.OK);
			entityWrapper.setT(rdsInvoiceDTO);
			entityWrapper.setMessage(" Find RdsInvoice by id=" + id + " succeeded");
		}
		return entityWrapper;

	}

	@Override

	public EntityWrapper<List<RdsInvoiceDTO>> findAllRdsInvoice1()
	{

		EntityWrapper<List<RdsInvoiceDTO>> entityWrapperList = new EntityWrapper<List<RdsInvoiceDTO>>();
		entityWrapperList.setT(null);
		entityWrapperList.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapperList.setMessage("Entity not found by query ");
		List<RdsInvoiceDTO> rdsInvoiceDTOList = dTOConverter.getRdsInvoiceDTOList(rdsInvoiceDAO.findAllRdsInvoice1());
		if (rdsInvoiceDTOList != null && rdsInvoiceDTOList.size() > 0)
		{
			entityWrapperList.setHttpStatus(HttpStatus.OK);
			entityWrapperList.setT(rdsInvoiceDTOList);
			entityWrapperList.setMessage("EntityList  found by Query ");
		}
		return entityWrapperList;

	}

	@Override

	public EntityWrapper<RdsInvoiceDTO> createRdsInvoice(RdsInvoiceDTO rdsInvoiceDTO)

	{

		EntityWrapper<RdsInvoiceDTO> dTOentityWrapper = dTOConverter.getRdsInvoiceDTOEntityWrapper(
				rdsInvoiceDAO.createRdsInvoice(dTOConverter.getRdsInvoice(rdsInvoiceDTO)));
		return dTOentityWrapper;

	}

	@Override

	public EntityWrapper<RdsInvoiceDTO> updateRdsInvoice(RdsInvoiceDTO rdsInvoiceDTO)

	{

		EntityWrapper<RdsInvoiceDTO> dTOentityWrapper = dTOConverter.getRdsInvoiceDTOEntityWrapper(
				rdsInvoiceDAO.updateRdsInvoice(dTOConverter.getRdsInvoice(rdsInvoiceDTO)));
		return dTOentityWrapper;

	}

	@Override

	public EntityWrapper<RdsInvoiceDTO> updateRdsInvoiceByNonEmptyVal(RdsInvoiceDTO rdsInvoiceDTO)

	{

		EntityWrapper<RdsInvoiceDTO> dTOentityWrapper = dTOConverter.getRdsInvoiceDTOEntityWrapper(
				rdsInvoiceDAO.updateRdsInvoiceByNonEmptyVal(dTOConverter.getRdsInvoice(rdsInvoiceDTO)));
		return dTOentityWrapper;

	}

	@Override

	public EntityWrapper<Long> deleteRdsInvoice(long id)

	{
		EntityWrapper<Long> entityWrapper = new EntityWrapper<Long>();
		entityWrapper.setT(new Long(-1));
		entityWrapper.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapper.setMessage(" Delete RdsInvoice by id=" + id + " Failed");
		long deletedId = rdsInvoiceDAO.deleteRdsInvoice(id);
		if (deletedId != -1)
		{
			entityWrapper.setHttpStatus(HttpStatus.OK);
			entityWrapper.setT(deletedId);
			entityWrapper.setMessage(" Delete RdsInvoice by id=" + id + " succeeded");
		}
		return entityWrapper;

	}

}
