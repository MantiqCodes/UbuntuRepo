package com.retail.store.discount.dao;

import java.util.List;
import com.retail.store.discount.model.RdsInvoiceItems;
import com.retail.store.discount.util.EntityWrapper;

public interface RdsInvoiceItemsDAO

{

	public RdsInvoiceItems findRdsInvoiceItemsById(long id);

	public List<RdsInvoiceItems> findAllRdsInvoiceItems1();

	public EntityWrapper<RdsInvoiceItems> createRdsInvoiceItems(RdsInvoiceItems rdsInvoiceItems);

	public long deleteRdsInvoiceItems(long id);

	public EntityWrapper<RdsInvoiceItems> updateRdsInvoiceItemsByNonEmptyVal(RdsInvoiceItems rdsInvoiceItems);

	public EntityWrapper<RdsInvoiceItems> updateRdsInvoiceItems(RdsInvoiceItems rdsInvoiceItems);

}
