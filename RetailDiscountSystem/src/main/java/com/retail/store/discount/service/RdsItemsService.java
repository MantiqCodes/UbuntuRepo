package com.retail.store.discount.service;

import java.util.List;
import com.retail.store.discount.dto.RdsItemsDTO;
import com.retail.store.discount.util.EntityWrapper;

public interface RdsItemsService

{

	public EntityWrapper<RdsItemsDTO> findRdsItemsById(long id);

	public EntityWrapper<List<RdsItemsDTO>> findAllRdsItems1();

	public EntityWrapper<RdsItemsDTO> createRdsItems(RdsItemsDTO rdsItemsDTO);

	public EntityWrapper<RdsItemsDTO> updateRdsItems(RdsItemsDTO rdsItemsDTO);

	public EntityWrapper<RdsItemsDTO> updateRdsItemsByNonEmptyVal(RdsItemsDTO rdsItemsDTO);

	public EntityWrapper<Long> deleteRdsItems(long id);

}
