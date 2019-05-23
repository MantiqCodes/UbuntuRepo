package com.retail.store.discount.service;

import java.util.List;
import com.retail.store.discount.dto.RdsInvoiceItemsDTO;
import com.retail.store.discount.util.EntityWrapper;

public interface RdsInvoiceItemsService

{

	public EntityWrapper<RdsInvoiceItemsDTO> findRdsInvoiceItemsById(long id);

	public EntityWrapper<List<RdsInvoiceItemsDTO>> findAllRdsInvoiceItems1();

	public EntityWrapper<RdsInvoiceItemsDTO> createRdsInvoiceItems(RdsInvoiceItemsDTO rdsInvoiceItemsDTO);

	public EntityWrapper<RdsInvoiceItemsDTO> updateRdsInvoiceItems(RdsInvoiceItemsDTO rdsInvoiceItemsDTO);

	public EntityWrapper<RdsInvoiceItemsDTO> updateRdsInvoiceItemsByNonEmptyVal(RdsInvoiceItemsDTO rdsInvoiceItemsDTO);

	public EntityWrapper<Long> deleteRdsInvoiceItems(long id);

}
