package com.retail.store.discount.service;

import com.retail.store.discount.dto.DTOConverter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.retail.store.discount.dto.RdsInventoryDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.retail.store.discount.util.EntityWrapper;
import com.retail.store.discount.dao.RdsInventoryDAO;
import org.springframework.http.HttpStatus;

@Service

@Transactional

public class RdsInventoryServiceImpl implements RdsInventoryService

{

	@Autowired

	private RdsInventoryDAO rdsInventoryDAO;

	private DTOConverter dTOConverter = new DTOConverter();

	@Override

	public EntityWrapper<RdsInventoryDTO> findRdsInventoryById(long id)

	{
		EntityWrapper<RdsInventoryDTO> entityWrapper = new EntityWrapper<RdsInventoryDTO>();
		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapper.setMessage(" Find RdsInventory by id=" + id + " Failed");
		RdsInventoryDTO rdsInventoryDTO = dTOConverter.getRdsInventoryDTO(rdsInventoryDAO.findRdsInventoryById(id));
		if (rdsInventoryDTO != null && rdsInventoryDTO.getId() != -1)
		{
			entityWrapper.setHttpStatus(HttpStatus.OK);
			entityWrapper.setT(rdsInventoryDTO);
			entityWrapper.setMessage(" Find RdsInventory by id=" + id + " succeeded");
		}
		return entityWrapper;

	}

	@Override

	public EntityWrapper<List<RdsInventoryDTO>> findAllRdsInventory1()
	{

		EntityWrapper<List<RdsInventoryDTO>> entityWrapperList = new EntityWrapper<List<RdsInventoryDTO>>();
		entityWrapperList.setT(null);
		entityWrapperList.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapperList.setMessage("Entity not found by query ");
		List<RdsInventoryDTO> rdsInventoryDTOList = dTOConverter
				.getRdsInventoryDTOList(rdsInventoryDAO.findAllRdsInventory1());
		if (rdsInventoryDTOList != null && rdsInventoryDTOList.size() > 0)
		{
			entityWrapperList.setHttpStatus(HttpStatus.OK);
			entityWrapperList.setT(rdsInventoryDTOList);
			entityWrapperList.setMessage("EntityList  found by Query ");
		}
		return entityWrapperList;

	}

	@Override

	public EntityWrapper<RdsInventoryDTO> createRdsInventory(RdsInventoryDTO rdsInventoryDTO)

	{

		EntityWrapper<RdsInventoryDTO> dTOentityWrapper = dTOConverter.getRdsInventoryDTOEntityWrapper(
				rdsInventoryDAO.createRdsInventory(dTOConverter.getRdsInventory(rdsInventoryDTO)));
		return dTOentityWrapper;

	}

	@Override

	public EntityWrapper<RdsInventoryDTO> updateRdsInventory(RdsInventoryDTO rdsInventoryDTO)

	{

		EntityWrapper<RdsInventoryDTO> dTOentityWrapper = dTOConverter.getRdsInventoryDTOEntityWrapper(
				rdsInventoryDAO.updateRdsInventory(dTOConverter.getRdsInventory(rdsInventoryDTO)));
		return dTOentityWrapper;

	}

	@Override

	public EntityWrapper<RdsInventoryDTO> updateRdsInventoryByNonEmptyVal(RdsInventoryDTO rdsInventoryDTO)

	{

		EntityWrapper<RdsInventoryDTO> dTOentityWrapper = dTOConverter.getRdsInventoryDTOEntityWrapper(
				rdsInventoryDAO.updateRdsInventoryByNonEmptyVal(dTOConverter.getRdsInventory(rdsInventoryDTO)));
		return dTOentityWrapper;

	}

	@Override

	public EntityWrapper<Long> deleteRdsInventory(long id)

	{
		EntityWrapper<Long> entityWrapper = new EntityWrapper<Long>();
		entityWrapper.setT(new Long(-1));
		entityWrapper.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapper.setMessage(" Delete RdsInventory by id=" + id + " Failed");
		long deletedId = rdsInventoryDAO.deleteRdsInventory(id);
		if (deletedId != -1)
		{
			entityWrapper.setHttpStatus(HttpStatus.OK);
			entityWrapper.setT(deletedId);
			entityWrapper.setMessage(" Delete RdsInventory by id=" + id + " succeeded");
		}
		return entityWrapper;

	}

}
