package com.retail.store.discount.dao;

import java.util.List;
import com.retail.store.discount.util.EntityWrapper;
import com.retail.store.discount.model.RdsItems;

public interface RdsItemsDAO

{

	public RdsItems findRdsItemsById(long id);

	public List<RdsItems> findAllRdsItems1();

	public EntityWrapper<RdsItems> createRdsItems(RdsItems rdsItems);

	public long deleteRdsItems(long id);

	public EntityWrapper<RdsItems> updateRdsItemsByNonEmptyVal(RdsItems rdsItems);

	public EntityWrapper<RdsItems> updateRdsItems(RdsItems rdsItems);

}
