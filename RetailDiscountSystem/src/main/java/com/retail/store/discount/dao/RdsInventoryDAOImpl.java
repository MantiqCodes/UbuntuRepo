package com.retail.store.discount.dao;

import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import com.retail.store.discount.util.EntityWrapper;
import javax.persistence.EntityManager;
import org.springframework.http.HttpStatus;
import com.retail.store.discount.model.RdsInventory;

@Repository

public class RdsInventoryDAOImpl implements RdsInventoryDAO

{

	@PersistenceContext(unitName = "RETAIL_DISCOUNT_SERVER_PU")

	private EntityManager entityManager;

	@Override

	public RdsInventory findRdsInventoryById(long id)

	{

		return entityManager.find(RdsInventory.class, id);

	}

	@Override

	public List<RdsInventory> findAllRdsInventory1()
	{

		List<RdsInventory> rdsInventoryList = null;

		try

		{

			Query findAllRdsInventory1Query = entityManager.createNamedQuery("findAllRdsInventory1");

			rdsInventoryList = (List<RdsInventory>) findAllRdsInventory1Query.getResultList();

			return rdsInventoryList;

		}

		catch (NoResultException nRsltExcptn)
		{
			System.out.println(">>>>>" + nRsltExcptn.getMessage().toString());
		}
		return null;

	}

	@Override

	public EntityWrapper<RdsInventory> createRdsInventory(RdsInventory rdsInventory)
	{

		EntityWrapper<RdsInventory> entityWrapper = new EntityWrapper<RdsInventory>();

		entityManager.persist(rdsInventory);

		entityWrapper.setT(rdsInventory);
		entityWrapper.setHttpStatus(HttpStatus.CREATED);
		entityWrapper.setMessage("Entity created :");
		return entityWrapper;

	}

	@Override

	public long deleteRdsInventory(long id)
	{

		long rdsInventoryId = -1;

		RdsInventory rdsInventory = entityManager.find(RdsInventory.class, id);

		if (rdsInventory != null && rdsInventory.getId() > -1)

		{

			rdsInventoryId = rdsInventory.getId();

			entityManager.remove(entityManager.merge(rdsInventory));

		}
		return rdsInventoryId;

	}

	@Override

	public EntityWrapper<RdsInventory> updateRdsInventoryByNonEmptyVal(RdsInventory rdsInventory)
	{

		EntityWrapper<RdsInventory> entityWrapper = new EntityWrapper<RdsInventory>();

		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NOT_FOUND);
		entityWrapper.setMessage("Entity update :failed");
		if (rdsInventory != null && rdsInventory.getId() > -1)
		{

			RdsInventory attachedRdsInventory = entityManager.find(RdsInventory.class, rdsInventory.getId());
			if (attachedRdsInventory != null)
			{

				if (rdsInventory.getId() > -1)
					attachedRdsInventory.setId(rdsInventory.getId());
				if (rdsInventory.getRdsItemsItem() != null)
					attachedRdsInventory.setRdsItemsItem(rdsInventory.getRdsItemsItem());
				if (rdsInventory.getQtyOnHand() > -1)
					attachedRdsInventory.setQtyOnHand(rdsInventory.getQtyOnHand());
				if (rdsInventory.getQtySold() > -1)
					attachedRdsInventory.setQtySold(rdsInventory.getQtySold());
				if (rdsInventory.getQtyTotal() > -1)
					attachedRdsInventory.setQtyTotal(rdsInventory.getQtyTotal());
				if (rdsInventory.getEntDate() != null)
					attachedRdsInventory.setEntDate(rdsInventory.getEntDate());
				attachedRdsInventory = entityManager.merge(attachedRdsInventory);

				entityWrapper.setT(attachedRdsInventory);
				entityWrapper.setHttpStatus(HttpStatus.OK);
				entityWrapper.setMessage("Entity update :SUCCEDED ");
			}

		}

		return entityWrapper;

	}

	@Override

	public EntityWrapper<RdsInventory> updateRdsInventory(RdsInventory rdsInventory)
	{

		EntityWrapper<RdsInventory> entityWrapper = new EntityWrapper<RdsInventory>();

		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NOT_FOUND);
		entityWrapper.setMessage("Entity update :failed");
		if (rdsInventory != null && rdsInventory.getId() > -1)
		{

			RdsInventory attachedRdsInventory = entityManager.find(RdsInventory.class, rdsInventory.getId());
			if (attachedRdsInventory != null)
			{

				attachedRdsInventory.setId(rdsInventory.getId());

				attachedRdsInventory.setRdsItemsItem(rdsInventory.getRdsItemsItem());

				attachedRdsInventory.setQtyOnHand(rdsInventory.getQtyOnHand());

				attachedRdsInventory.setQtySold(rdsInventory.getQtySold());

				attachedRdsInventory.setQtyTotal(rdsInventory.getQtyTotal());

				attachedRdsInventory.setEntDate(rdsInventory.getEntDate());
				attachedRdsInventory = entityManager.merge(attachedRdsInventory);

				entityWrapper.setT(attachedRdsInventory);
				entityWrapper.setHttpStatus(HttpStatus.OK);
				entityWrapper.setMessage("Entity update :SUCCEDED ");
			}

		}

		return entityWrapper;

	}

}
