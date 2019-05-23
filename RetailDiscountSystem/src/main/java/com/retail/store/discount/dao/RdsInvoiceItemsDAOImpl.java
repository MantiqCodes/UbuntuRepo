package com.retail.store.discount.dao;

import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import com.retail.store.discount.model.RdsInvoiceItems;
import com.retail.store.discount.util.EntityWrapper;
import javax.persistence.EntityManager;
import org.springframework.http.HttpStatus;
import javax.persistence.NonUniqueResultException;

@Repository

public class RdsInvoiceItemsDAOImpl implements RdsInvoiceItemsDAO

{

	@PersistenceContext(unitName = "RETAIL_DISCOUNT_SERVER_PU")

	private EntityManager entityManager;

	@Override

	public RdsInvoiceItems findRdsInvoiceItemsById(long id)

	{

		return entityManager.find(RdsInvoiceItems.class, id);

	}

	@Override

	public List<RdsInvoiceItems> findAllRdsInvoiceItems1()
	{

		List<RdsInvoiceItems> rdsInvoiceItemsList = null;

		try

		{

			Query findAllRdsInvoiceItems1Query = entityManager.createNamedQuery("findAllRdsInvoiceItems1");

			rdsInvoiceItemsList = (List<RdsInvoiceItems>) findAllRdsInvoiceItems1Query.getResultList();

			return rdsInvoiceItemsList;

		}

		catch (NonUniqueResultException nUnqRsltExc)
		{
			System.out.println(">>>" + nUnqRsltExc.getMessage().toString());
		}

		catch (NoResultException nRsltExcptn)
		{
			System.out.println(">>>>>" + nRsltExcptn.getMessage().toString());
		}
		return null;

	}

	@Override

	public EntityWrapper<RdsInvoiceItems> createRdsInvoiceItems(RdsInvoiceItems rdsInvoiceItems)
	{

		EntityWrapper<RdsInvoiceItems> entityWrapper = new EntityWrapper<RdsInvoiceItems>();

		entityManager.persist(rdsInvoiceItems);

		entityWrapper.setT(rdsInvoiceItems);
		entityWrapper.setHttpStatus(HttpStatus.CREATED);
		entityWrapper.setMessage("Entity created :");
		return entityWrapper;

	}

	@Override

	public long deleteRdsInvoiceItems(long id)
	{

		long rdsInvoiceItemsId = -1;

		RdsInvoiceItems rdsInvoiceItems = entityManager.find(RdsInvoiceItems.class, id);

		if (rdsInvoiceItems != null && rdsInvoiceItems.getId() > -1)

		{

			rdsInvoiceItemsId = rdsInvoiceItems.getId();

			entityManager.remove(entityManager.merge(rdsInvoiceItems));

		}
		return rdsInvoiceItemsId;

	}

	@Override

	public EntityWrapper<RdsInvoiceItems> updateRdsInvoiceItemsByNonEmptyVal(RdsInvoiceItems rdsInvoiceItems)
	{

		EntityWrapper<RdsInvoiceItems> entityWrapper = new EntityWrapper<RdsInvoiceItems>();

		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NOT_FOUND);
		entityWrapper.setMessage("Entity update :failed");
		if (rdsInvoiceItems != null && rdsInvoiceItems.getId() > -1)
		{

			RdsInvoiceItems attachedRdsInvoiceItems = entityManager.find(RdsInvoiceItems.class,
					rdsInvoiceItems.getId());
			if (attachedRdsInvoiceItems != null)
			{

				if (rdsInvoiceItems.getId() > -1)
					attachedRdsInvoiceItems.setId(rdsInvoiceItems.getId());
				if (rdsInvoiceItems.getRdsItemsItem() != null)
					attachedRdsInvoiceItems.setRdsItemsItem(rdsInvoiceItems.getRdsItemsItem());
				if (rdsInvoiceItems.getRdsInvoiceInvoice() != null)
					attachedRdsInvoiceItems.setRdsInvoiceInvoice(rdsInvoiceItems.getRdsInvoiceInvoice());
				if (rdsInvoiceItems.getQty() > -1)
					attachedRdsInvoiceItems.setQty(rdsInvoiceItems.getQty());
				if (rdsInvoiceItems.getRate() > -1)
					attachedRdsInvoiceItems.setRate(rdsInvoiceItems.getRate());
				if (rdsInvoiceItems.getItemTotal() > -1)
					attachedRdsInvoiceItems.setItemTotal(rdsInvoiceItems.getItemTotal());
				attachedRdsInvoiceItems = entityManager.merge(attachedRdsInvoiceItems);

				entityWrapper.setT(attachedRdsInvoiceItems);
				entityWrapper.setHttpStatus(HttpStatus.OK);
				entityWrapper.setMessage("Entity update :SUCCEDED ");
			}

		}

		return entityWrapper;

	}

	@Override

	public EntityWrapper<RdsInvoiceItems> updateRdsInvoiceItems(RdsInvoiceItems rdsInvoiceItems)
	{

		EntityWrapper<RdsInvoiceItems> entityWrapper = new EntityWrapper<RdsInvoiceItems>();

		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NOT_FOUND);
		entityWrapper.setMessage("Entity update :failed");
		if (rdsInvoiceItems != null && rdsInvoiceItems.getId() > -1)
		{

			RdsInvoiceItems attachedRdsInvoiceItems = entityManager.find(RdsInvoiceItems.class,
					rdsInvoiceItems.getId());
			if (attachedRdsInvoiceItems != null)
			{

				attachedRdsInvoiceItems.setId(rdsInvoiceItems.getId());

				attachedRdsInvoiceItems.setRdsItemsItem(rdsInvoiceItems.getRdsItemsItem());

				attachedRdsInvoiceItems.setRdsInvoiceInvoice(rdsInvoiceItems.getRdsInvoiceInvoice());

				attachedRdsInvoiceItems.setQty(rdsInvoiceItems.getQty());

				attachedRdsInvoiceItems.setRate(rdsInvoiceItems.getRate());

				attachedRdsInvoiceItems.setItemTotal(rdsInvoiceItems.getItemTotal());
				attachedRdsInvoiceItems = entityManager.merge(attachedRdsInvoiceItems);

				entityWrapper.setT(attachedRdsInvoiceItems);
				entityWrapper.setHttpStatus(HttpStatus.OK);
				entityWrapper.setMessage("Entity update :SUCCEDED ");
			}

		}

		return entityWrapper;

	}

}
