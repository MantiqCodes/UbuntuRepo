package com.retail.store.discount.service;

import com.retail.store.discount.dto.DTOConverter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.retail.store.discount.dao.RdsItemsDAO;
import com.retail.store.discount.dto.RdsItemsDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.retail.store.discount.util.EntityWrapper;
import org.springframework.http.HttpStatus;

@Service

@Transactional

public class RdsItemsServiceImpl implements RdsItemsService

{

	@Autowired

	private RdsItemsDAO rdsItemsDAO;

	private DTOConverter dTOConverter = new DTOConverter();

	@Override

	public EntityWrapper<RdsItemsDTO> findRdsItemsById(long id)

	{
		EntityWrapper<RdsItemsDTO> entityWrapper = new EntityWrapper<RdsItemsDTO>();
		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapper.setMessage(" Find RdsItems by id=" + id + " Failed");
		RdsItemsDTO rdsItemsDTO = dTOConverter.getRdsItemsDTO(rdsItemsDAO.findRdsItemsById(id));
		if (rdsItemsDTO != null && rdsItemsDTO.getId() != -1)
		{
			entityWrapper.setHttpStatus(HttpStatus.OK);
			entityWrapper.setT(rdsItemsDTO);
			entityWrapper.setMessage(" Find RdsItems by id=" + id + " succeeded");
		}
		return entityWrapper;

	}

	@Override

	public EntityWrapper<List<RdsItemsDTO>> findAllRdsItems1()
	{

		EntityWrapper<List<RdsItemsDTO>> entityWrapperList = new EntityWrapper<List<RdsItemsDTO>>();
		entityWrapperList.setT(null);
		entityWrapperList.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapperList.setMessage("Entity not found by query ");
		List<RdsItemsDTO> rdsItemsDTOList = dTOConverter.getRdsItemsDTOList(rdsItemsDAO.findAllRdsItems1());
		if (rdsItemsDTOList != null && rdsItemsDTOList.size() > 0)
		{
			entityWrapperList.setHttpStatus(HttpStatus.OK);
			entityWrapperList.setT(rdsItemsDTOList);
			entityWrapperList.setMessage("EntityList  found by Query ");
		}
		return entityWrapperList;

	}

	@Override

	public EntityWrapper<RdsItemsDTO> createRdsItems(RdsItemsDTO rdsItemsDTO)

	{

		EntityWrapper<RdsItemsDTO> dTOentityWrapper = dTOConverter
				.getRdsItemsDTOEntityWrapper(rdsItemsDAO.createRdsItems(dTOConverter.getRdsItems(rdsItemsDTO)));
		return dTOentityWrapper;

	}

	@Override

	public EntityWrapper<RdsItemsDTO> updateRdsItems(RdsItemsDTO rdsItemsDTO)

	{

		EntityWrapper<RdsItemsDTO> dTOentityWrapper = dTOConverter
				.getRdsItemsDTOEntityWrapper(rdsItemsDAO.updateRdsItems(dTOConverter.getRdsItems(rdsItemsDTO)));
		return dTOentityWrapper;

	}

	@Override

	public EntityWrapper<RdsItemsDTO> updateRdsItemsByNonEmptyVal(RdsItemsDTO rdsItemsDTO)

	{

		EntityWrapper<RdsItemsDTO> dTOentityWrapper = dTOConverter.getRdsItemsDTOEntityWrapper(
				rdsItemsDAO.updateRdsItemsByNonEmptyVal(dTOConverter.getRdsItems(rdsItemsDTO)));
		return dTOentityWrapper;

	}

	@Override

	public EntityWrapper<Long> deleteRdsItems(long id)

	{
		EntityWrapper<Long> entityWrapper = new EntityWrapper<Long>();
		entityWrapper.setT(new Long(-1));
		entityWrapper.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapper.setMessage(" Delete RdsItems by id=" + id + " Failed");
		long deletedId = rdsItemsDAO.deleteRdsItems(id);
		if (deletedId != -1)
		{
			entityWrapper.setHttpStatus(HttpStatus.OK);
			entityWrapper.setT(deletedId);
			entityWrapper.setMessage(" Delete RdsItems by id=" + id + " succeeded");
		}
		return entityWrapper;

	}

}
