package com.retail.store.discount.service;

import java.util.List;
import com.retail.store.discount.dto.RdsUsersDTO;
import com.retail.store.discount.util.EntityWrapper;

public interface RdsUsersService

{

	public EntityWrapper<RdsUsersDTO> findRdsUsersById(long id);

	public EntityWrapper<List<RdsUsersDTO>> findAllRdsUsers1();

	public EntityWrapper<RdsUsersDTO> findUniqueRdsUsersBYUsername2(String username);

	public EntityWrapper<RdsUsersDTO> findUniqueRdsUsersBYEmail4(String email);

	public EntityWrapper<RdsUsersDTO> createRdsUsers(RdsUsersDTO rdsUsersDTO);

	public EntityWrapper<RdsUsersDTO> updateRdsUsers(RdsUsersDTO rdsUsersDTO);

	public EntityWrapper<RdsUsersDTO> updateRdsUsersByNonEmptyVal(RdsUsersDTO rdsUsersDTO);

	public EntityWrapper<Long> deleteRdsUsers(long id);

}
