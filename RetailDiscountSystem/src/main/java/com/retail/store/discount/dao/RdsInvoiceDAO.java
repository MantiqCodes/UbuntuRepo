package com.retail.store.discount.dao;

import java.util.List;
import com.retail.store.discount.model.RdsInvoice;
import com.retail.store.discount.util.EntityWrapper;

public interface RdsInvoiceDAO

{

	public RdsInvoice findRdsInvoiceById(long id);

	public List<RdsInvoice> findAllRdsInvoice1();

	public EntityWrapper<RdsInvoice> createRdsInvoice(RdsInvoice rdsInvoice);

	public long deleteRdsInvoice(long id);

	public EntityWrapper<RdsInvoice> updateRdsInvoiceByNonEmptyVal(RdsInvoice rdsInvoice);

	public EntityWrapper<RdsInvoice> updateRdsInvoice(RdsInvoice rdsInvoice);

}
