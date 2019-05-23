package com.retail.store.discount.dao;

import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import com.retail.store.discount.util.EntityWrapper;
import javax.persistence.EntityManager;
import org.springframework.http.HttpStatus;
import com.retail.store.discount.model.RdsItems;
import javax.persistence.NonUniqueResultException;

@Repository

public class RdsItemsDAOImpl implements RdsItemsDAO

{

	@PersistenceContext(unitName = "RETAIL_DISCOUNT_SERVER_PU")

	private EntityManager entityManager;

	@Override

	public RdsItems findRdsItemsById(long id)

	{

		return entityManager.find(RdsItems.class, id);

	}

	@Override

	public List<RdsItems> findAllRdsItems1()
	{

		List<RdsItems> rdsItemsList = null;

		try

		{

			Query findAllRdsItems1Query = entityManager.createNamedQuery("findAllRdsItems1");

			rdsItemsList = (List<RdsItems>) findAllRdsItems1Query.getResultList();

			return rdsItemsList;

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

	public EntityWrapper<RdsItems> createRdsItems(RdsItems rdsItems)
	{

		EntityWrapper<RdsItems> entityWrapper = new EntityWrapper<RdsItems>();

		entityManager.persist(rdsItems);

		entityWrapper.setT(rdsItems);
		entityWrapper.setHttpStatus(HttpStatus.CREATED);
		entityWrapper.setMessage("Entity created :");
		return entityWrapper;

	}

	@Override

	public long deleteRdsItems(long id)
	{

		long rdsItemsId = -1;

		RdsItems rdsItems = entityManager.find(RdsItems.class, id);

		if (rdsItems != null && rdsItems.getId() > -1)

		{

			rdsItemsId = rdsItems.getId();

			entityManager.remove(entityManager.merge(rdsItems));

		}
		return rdsItemsId;

	}

	@Override

	public EntityWrapper<RdsItems> updateRdsItemsByNonEmptyVal(RdsItems rdsItems)
	{

		EntityWrapper<RdsItems> entityWrapper = new EntityWrapper<RdsItems>();

		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NOT_FOUND);
		entityWrapper.setMessage("Entity update :failed");
		if (rdsItems != null && rdsItems.getId() > -1)
		{

			RdsItems attachedRdsItems = entityManager.find(RdsItems.class, rdsItems.getId());
			if (attachedRdsItems != null)
			{

				if (rdsItems.getId() > -1)
					attachedRdsItems.setId(rdsItems.getId());
				if (rdsItems.getName() != null && !rdsItems.getName().equals(""))
					attachedRdsItems.setName(rdsItems.getName());
				if (rdsItems.getDescription() != null && !rdsItems.getDescription().equals(""))
					attachedRdsItems.setDescription(rdsItems.getDescription());
				if (rdsItems.getPrice() > -1)
					attachedRdsItems.setPrice(rdsItems.getPrice());
				if (rdsItems.getCategory() != null && !rdsItems.getCategory().equals(""))
					attachedRdsItems.setCategory(rdsItems.getCategory());
				if (rdsItems.getUnitOfMeasure() != null && !rdsItems.getUnitOfMeasure().equals(""))
					attachedRdsItems.setUnitOfMeasure(rdsItems.getUnitOfMeasure());
				attachedRdsItems = entityManager.merge(attachedRdsItems);

				entityWrapper.setT(attachedRdsItems);
				entityWrapper.setHttpStatus(HttpStatus.OK);
				entityWrapper.setMessage("Entity update :SUCCEDED ");
			}

		}

		return entityWrapper;

	}

	@Override

	public EntityWrapper<RdsItems> updateRdsItems(RdsItems rdsItems)
	{

		EntityWrapper<RdsItems> entityWrapper = new EntityWrapper<RdsItems>();

		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NOT_FOUND);
		entityWrapper.setMessage("Entity update :failed");
		if (rdsItems != null && rdsItems.getId() > -1)
		{

			RdsItems attachedRdsItems = entityManager.find(RdsItems.class, rdsItems.getId());
			if (attachedRdsItems != null)
			{

				attachedRdsItems.setId(rdsItems.getId());

				attachedRdsItems.setName(rdsItems.getName());

				attachedRdsItems.setDescription(rdsItems.getDescription());

				attachedRdsItems.setPrice(rdsItems.getPrice());

				attachedRdsItems.setCategory(rdsItems.getCategory());

				attachedRdsItems.setUnitOfMeasure(rdsItems.getUnitOfMeasure());
				attachedRdsItems = entityManager.merge(attachedRdsItems);

				entityWrapper.setT(attachedRdsItems);
				entityWrapper.setHttpStatus(HttpStatus.OK);
				entityWrapper.setMessage("Entity update :SUCCEDED ");
			}

		}

		return entityWrapper;

	}

}
