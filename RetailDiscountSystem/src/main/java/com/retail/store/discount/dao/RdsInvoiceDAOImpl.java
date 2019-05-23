package com.retail.store.discount.dao;

import java.util.List;
import javax.persistence.NoResultException;
import com.retail.store.discount.model.RdsInvoice;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import com.retail.store.discount.util.EntityWrapper;
import javax.persistence.EntityManager;
import org.springframework.http.HttpStatus;
import javax.persistence.NonUniqueResultException;

@Repository

public class RdsInvoiceDAOImpl implements RdsInvoiceDAO

{

	@PersistenceContext(unitName = "RETAIL_DISCOUNT_SERVER_PU")

	private EntityManager entityManager;

	@Override

	public RdsInvoice findRdsInvoiceById(long id)

	{

		return entityManager.find(RdsInvoice.class, id);

	}

	@Override

	public List<RdsInvoice> findAllRdsInvoice1()
	{

		List<RdsInvoice> rdsInvoiceList = null;

		try

		{

			Query findAllRdsInvoice1Query = entityManager.createNamedQuery("findAllRdsInvoice1");

			rdsInvoiceList = (List<RdsInvoice>) findAllRdsInvoice1Query.getResultList();

			return rdsInvoiceList;

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

	public EntityWrapper<RdsInvoice> createRdsInvoice(RdsInvoice rdsInvoice)
	{

		EntityWrapper<RdsInvoice> entityWrapper = new EntityWrapper<RdsInvoice>();

		entityManager.persist(rdsInvoice);

		entityWrapper.setT(rdsInvoice);
		entityWrapper.setHttpStatus(HttpStatus.CREATED);
		entityWrapper.setMessage("Entity created :");
		return entityWrapper;

	}

	@Override

	public long deleteRdsInvoice(long id)
	{

		long rdsInvoiceId = -1;

		RdsInvoice rdsInvoice = entityManager.find(RdsInvoice.class, id);

		if (rdsInvoice != null && rdsInvoice.getId() > -1)

		{

			rdsInvoiceId = rdsInvoice.getId();

			entityManager.remove(entityManager.merge(rdsInvoice));

		}
		return rdsInvoiceId;

	}

	@Override

	public EntityWrapper<RdsInvoice> updateRdsInvoiceByNonEmptyVal(RdsInvoice rdsInvoice)
	{

		EntityWrapper<RdsInvoice> entityWrapper = new EntityWrapper<RdsInvoice>();

		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NOT_FOUND);
		entityWrapper.setMessage("Entity update :failed");
		if (rdsInvoice != null && rdsInvoice.getId() > -1)
		{

			RdsInvoice attachedRdsInvoice = entityManager.find(RdsInvoice.class, rdsInvoice.getId());
			if (attachedRdsInvoice != null)
			{

				if (rdsInvoice.getId() > -1)
					attachedRdsInvoice.setId(rdsInvoice.getId());
				if (rdsInvoice.getEntryCount() > -1)
					attachedRdsInvoice.setEntryCount(rdsInvoice.getEntryCount());
				if (rdsInvoice.getDocPrice() > -1)
					attachedRdsInvoice.setDocPrice(rdsInvoice.getDocPrice());
				if (rdsInvoice.getDocPriceAfterDiscount() > -1)
					attachedRdsInvoice.setDocPriceAfterDiscount(rdsInvoice.getDocPriceAfterDiscount());
				if (rdsInvoice.getDocDiscount() > -1)
					attachedRdsInvoice.setDocDiscount(rdsInvoice.getDocDiscount());
				if (rdsInvoice.getDiscountBase() != null && !rdsInvoice.getDiscountBase().equals(""))
					attachedRdsInvoice.setDiscountBase(rdsInvoice.getDiscountBase());
				if (rdsInvoice.getRdsUsersCustomer() != null)
					attachedRdsInvoice.setRdsUsersCustomer(rdsInvoice.getRdsUsersCustomer());
				if (rdsInvoice.getDocDate() != null)
					attachedRdsInvoice.setDocDate(rdsInvoice.getDocDate());
				attachedRdsInvoice = entityManager.merge(attachedRdsInvoice);

				entityWrapper.setT(attachedRdsInvoice);
				entityWrapper.setHttpStatus(HttpStatus.OK);
				entityWrapper.setMessage("Entity update :SUCCEDED ");
			}

		}

		return entityWrapper;

	}

	@Override

	public EntityWrapper<RdsInvoice> updateRdsInvoice(RdsInvoice rdsInvoice)
	{

		EntityWrapper<RdsInvoice> entityWrapper = new EntityWrapper<RdsInvoice>();

		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NOT_FOUND);
		entityWrapper.setMessage("Entity update :failed");
		if (rdsInvoice != null && rdsInvoice.getId() > -1)
		{

			RdsInvoice attachedRdsInvoice = entityManager.find(RdsInvoice.class, rdsInvoice.getId());
			if (attachedRdsInvoice != null)
			{

				attachedRdsInvoice.setId(rdsInvoice.getId());

				attachedRdsInvoice.setEntryCount(rdsInvoice.getEntryCount());

				attachedRdsInvoice.setDocPrice(rdsInvoice.getDocPrice());

				attachedRdsInvoice.setDocPriceAfterDiscount(rdsInvoice.getDocPriceAfterDiscount());

				attachedRdsInvoice.setDocDiscount(rdsInvoice.getDocDiscount());

				attachedRdsInvoice.setDiscountBase(rdsInvoice.getDiscountBase());

				attachedRdsInvoice.setRdsUsersCustomer(rdsInvoice.getRdsUsersCustomer());

				attachedRdsInvoice.setDocDate(rdsInvoice.getDocDate());
				attachedRdsInvoice = entityManager.merge(attachedRdsInvoice);

				entityWrapper.setT(attachedRdsInvoice);
				entityWrapper.setHttpStatus(HttpStatus.OK);
				entityWrapper.setMessage("Entity update :SUCCEDED ");
			}

		}

		return entityWrapper;

	}

}
