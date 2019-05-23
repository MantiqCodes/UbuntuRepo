package com.retail.store.discount.dao;

import java.util.List;
import com.retail.store.discount.model.RdsUsers;
import com.retail.store.discount.util.EntityWrapper;

public interface RdsUsersDAO

{

	public RdsUsers findRdsUsersById(long id);

	public List<RdsUsers> findAllRdsUsers1();

	public RdsUsers findUniqueRdsUsersBYUsername2(String username);

	public RdsUsers findUniqueRdsUsersBYEmail4(String email);

	public EntityWrapper<RdsUsers> createRdsUsers(RdsUsers rdsUsers);

	public long deleteRdsUsers(long id);

	public EntityWrapper<RdsUsers> updateRdsUsersByNonEmptyVal(RdsUsers rdsUsers);

	public EntityWrapper<RdsUsers> updateRdsUsers(RdsUsers rdsUsers);

}
