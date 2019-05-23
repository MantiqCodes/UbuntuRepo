package com.retail.store.discount.service;

import java.util.List;
import com.retail.store.discount.dto.RdsInventoryDTO;
import com.retail.store.discount.util.EntityWrapper;

public interface RdsInventoryService

{

	public EntityWrapper<RdsInventoryDTO> findRdsInventoryById(long id);

	public EntityWrapper<List<RdsInventoryDTO>> findAllRdsInventory1();

	public EntityWrapper<RdsInventoryDTO> createRdsInventory(RdsInventoryDTO rdsInventoryDTO);

	public EntityWrapper<RdsInventoryDTO> updateRdsInventory(RdsInventoryDTO rdsInventoryDTO);

	public EntityWrapper<RdsInventoryDTO> updateRdsInventoryByNonEmptyVal(RdsInventoryDTO rdsInventoryDTO);

	public EntityWrapper<Long> deleteRdsInventory(long id);

}
