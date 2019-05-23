package com.retail.store.discount.dao;

import java.util.List;
import com.retail.store.discount.util.EntityWrapper;
import com.retail.store.discount.model.RdsInventory;

public interface RdsInventoryDAO

{

	public RdsInventory findRdsInventoryById(long id);

	public List<RdsInventory> findAllRdsInventory1();

	public EntityWrapper<RdsInventory> createRdsInventory(RdsInventory rdsInventory);

	public long deleteRdsInventory(long id);

	public EntityWrapper<RdsInventory> updateRdsInventoryByNonEmptyVal(RdsInventory rdsInventory);

	public EntityWrapper<RdsInventory> updateRdsInventory(RdsInventory rdsInventory);

}
