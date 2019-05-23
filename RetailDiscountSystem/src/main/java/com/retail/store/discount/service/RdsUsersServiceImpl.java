package com.retail.store.discount.service;

import com.retail.store.discount.dto.DTOConverter;
import java.util.List;
import com.retail.store.discount.dto.RdsUsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.retail.store.discount.util.EntityWrapper;
import com.retail.store.discount.dao.RdsUsersDAO;
import org.springframework.http.HttpStatus;

@Service

@Transactional

public class RdsUsersServiceImpl implements RdsUsersService

{

	@Autowired

	private RdsUsersDAO rdsUsersDAO;

	private DTOConverter dTOConverter = new DTOConverter();

	@Override

	public EntityWrapper<RdsUsersDTO> findRdsUsersById(long id)

	{
		EntityWrapper<RdsUsersDTO> entityWrapper = new EntityWrapper<RdsUsersDTO>();
		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapper.setMessage(" Find RdsUsers by id=" + id + " Failed");
		RdsUsersDTO rdsUsersDTO = dTOConverter.getRdsUsersDTO(rdsUsersDAO.findRdsUsersById(id));
		if (rdsUsersDTO != null && rdsUsersDTO.getId() != -1)
		{
			entityWrapper.setHttpStatus(HttpStatus.OK);
			entityWrapper.setT(rdsUsersDTO);
			entityWrapper.setMessage(" Find RdsUsers by id=" + id + " succeeded");
		}
		return entityWrapper;

	}

	@Override

	public EntityWrapper<List<RdsUsersDTO>> findAllRdsUsers1()
	{

		EntityWrapper<List<RdsUsersDTO>> entityWrapperList = new EntityWrapper<List<RdsUsersDTO>>();
		entityWrapperList.setT(null);
		entityWrapperList.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapperList.setMessage("Entity not found by query ");
		List<RdsUsersDTO> rdsUsersDTOList = dTOConverter.getRdsUsersDTOList(rdsUsersDAO.findAllRdsUsers1());
		if (rdsUsersDTOList != null && rdsUsersDTOList.size() > 0)
		{
			entityWrapperList.setHttpStatus(HttpStatus.OK);
			entityWrapperList.setT(rdsUsersDTOList);
			entityWrapperList.setMessage("EntityList  found by Query ");
		}
		return entityWrapperList;

	}

	@Override

	public EntityWrapper<RdsUsersDTO> findUniqueRdsUsersBYUsername2(String username)
	{

		EntityWrapper<RdsUsersDTO> entityWrapper = new EntityWrapper<RdsUsersDTO>();
		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapper.setMessage("Entity not found by query ");
		RdsUsersDTO rdsUsersDTO = dTOConverter.getRdsUsersDTO(rdsUsersDAO.findUniqueRdsUsersBYUsername2(username));
		if (rdsUsersDTO != null)
		{
			entityWrapper.setHttpStatus(HttpStatus.OK);
			entityWrapper.setT(rdsUsersDTO);
			entityWrapper.setMessage("Entity  found by Query ");
		}
		return entityWrapper;

	}

	@Override

	public EntityWrapper<RdsUsersDTO> findUniqueRdsUsersBYEmail4(String email)
	{

		EntityWrapper<RdsUsersDTO> entityWrapper = new EntityWrapper<RdsUsersDTO>();
		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapper.setMessage("Entity not found by query ");
		RdsUsersDTO rdsUsersDTO = dTOConverter.getRdsUsersDTO(rdsUsersDAO.findUniqueRdsUsersBYEmail4(email));
		if (rdsUsersDTO != null)
		{
			entityWrapper.setHttpStatus(HttpStatus.OK);
			entityWrapper.setT(rdsUsersDTO);
			entityWrapper.setMessage("Entity  found by Query ");
		}
		return entityWrapper;

	}

	@Override

	public EntityWrapper<RdsUsersDTO> createRdsUsers(RdsUsersDTO rdsUsersDTO)

	{

		EntityWrapper<RdsUsersDTO> dTOentityWrapper = dTOConverter
				.getRdsUsersDTOEntityWrapper(rdsUsersDAO.createRdsUsers(dTOConverter.getRdsUsers(rdsUsersDTO)));
		return dTOentityWrapper;

	}

	@Override

	public EntityWrapper<RdsUsersDTO> updateRdsUsers(RdsUsersDTO rdsUsersDTO)

	{

		EntityWrapper<RdsUsersDTO> dTOentityWrapper = dTOConverter
				.getRdsUsersDTOEntityWrapper(rdsUsersDAO.updateRdsUsers(dTOConverter.getRdsUsers(rdsUsersDTO)));
		return dTOentityWrapper;

	}

	@Override

	public EntityWrapper<RdsUsersDTO> updateRdsUsersByNonEmptyVal(RdsUsersDTO rdsUsersDTO)

	{

		EntityWrapper<RdsUsersDTO> dTOentityWrapper = dTOConverter.getRdsUsersDTOEntityWrapper(
				rdsUsersDAO.updateRdsUsersByNonEmptyVal(dTOConverter.getRdsUsers(rdsUsersDTO)));
		return dTOentityWrapper;

	}

	@Override

	public EntityWrapper<Long> deleteRdsUsers(long id)

	{
		EntityWrapper<Long> entityWrapper = new EntityWrapper<Long>();
		entityWrapper.setT(new Long(-1));
		entityWrapper.setHttpStatus(HttpStatus.NO_CONTENT);
		entityWrapper.setMessage(" Delete RdsUsers by id=" + id + " Failed");
		long deletedId = rdsUsersDAO.deleteRdsUsers(id);
		if (deletedId != -1)
		{
			entityWrapper.setHttpStatus(HttpStatus.OK);
			entityWrapper.setT(deletedId);
			entityWrapper.setMessage(" Delete RdsUsers by id=" + id + " succeeded");
		}
		return entityWrapper;

	}

}
