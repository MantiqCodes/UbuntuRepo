package com.retail.store.discount.service;

import java.util.List;
import com.retail.store.discount.dto.RdsInvoiceDTO;
import com.retail.store.discount.util.EntityWrapper;

public interface RdsInvoiceService

{

	public EntityWrapper<RdsInvoiceDTO> findRdsInvoiceById(long id);

	public EntityWrapper<List<RdsInvoiceDTO>> findAllRdsInvoice1();

	public EntityWrapper<RdsInvoiceDTO> createRdsInvoice(RdsInvoiceDTO rdsInvoiceDTO);

	public EntityWrapper<RdsInvoiceDTO> updateRdsInvoice(RdsInvoiceDTO rdsInvoiceDTO);

	public EntityWrapper<RdsInvoiceDTO> updateRdsInvoiceByNonEmptyVal(RdsInvoiceDTO rdsInvoiceDTO);

	public EntityWrapper<Long> deleteRdsInvoice(long id);

}
