package com.retail.store.discount.dao;

import java.util.List;
import com.retail.store.discount.model.RdsUsers;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import com.retail.store.discount.util.EntityWrapper;
import javax.persistence.EntityManager;
import org.springframework.http.HttpStatus;
import javax.persistence.NonUniqueResultException;

@Repository

public class RdsUsersDAOImpl implements RdsUsersDAO

{

	@PersistenceContext(unitName = "RETAIL_DISCOUNT_SERVER_PU")

	private EntityManager entityManager;

	@Override

	public RdsUsers findRdsUsersById(long id)

	{

		return entityManager.find(RdsUsers.class, id);

	}

	@Override

	public List<RdsUsers> findAllRdsUsers1()
	{

		List<RdsUsers> rdsUsersList = null;

		try

		{

			Query findAllRdsUsers1Query = entityManager.createNamedQuery("findAllRdsUsers1");

			rdsUsersList = (List<RdsUsers>) findAllRdsUsers1Query.getResultList();

			return rdsUsersList;

		}

		catch (NoResultException nRsltExcptn)
		{
			System.out.println(">>>>>" + nRsltExcptn.getMessage().toString());
		}
		return null;

	}

	@Override

	public RdsUsers findUniqueRdsUsersBYUsername2(String username)
	{

		RdsUsers rdsUsers = null;

		try

		{

			Query findUniqueRdsUsersBYUsername2Query = entityManager.createNamedQuery("findUniqueRdsUsersBYUsername2");

			findUniqueRdsUsersBYUsername2Query.setParameter("username", username);

			rdsUsers = (RdsUsers) findUniqueRdsUsersBYUsername2Query.getSingleResult();

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

	public RdsUsers findUniqueRdsUsersBYEmail4(String email)
	{

		RdsUsers rdsUsers = null;

		try

		{

			Query findUniqueRdsUsersBYEmail4Query = entityManager.createNamedQuery("findUniqueRdsUsersBYEmail4");

			findUniqueRdsUsersBYEmail4Query.setParameter("email", email);

			rdsUsers = (RdsUsers) findUniqueRdsUsersBYEmail4Query.getSingleResult();

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

	public EntityWrapper<RdsUsers> createRdsUsers(RdsUsers rdsUsers)
	{

		EntityWrapper<RdsUsers> entityWrapper = new EntityWrapper<RdsUsers>();
		RdsUsers oldRdsUsers = null;

		oldRdsUsers = findUniqueRdsUsersBYUsername2(rdsUsers.getUsername());

		if (oldRdsUsers != null)

		{
			entityWrapper.setT(oldRdsUsers);
			entityWrapper.setHttpStatus(HttpStatus.CONFLICT);
			entityWrapper.setMessage("Returned old Entity : conflict in non-unique  rdsUsers.getUsername()");
			return entityWrapper;
		}

		oldRdsUsers = findUniqueRdsUsersBYEmail4(rdsUsers.getEmail());

		if (oldRdsUsers != null)

		{
			entityWrapper.setT(oldRdsUsers);
			entityWrapper.setHttpStatus(HttpStatus.CONFLICT);
			entityWrapper.setMessage("Returned old Entity : conflict in non-unique  rdsUsers.getEmail()");
			return entityWrapper;
		}

		entityManager.persist(rdsUsers);

		entityWrapper.setT(rdsUsers);
		entityWrapper.setHttpStatus(HttpStatus.CREATED);
		entityWrapper.setMessage("Entity created :");
		return entityWrapper;

	}

	@Override

	public long deleteRdsUsers(long id)
	{

		long rdsUsersId = -1;

		RdsUsers rdsUsers = entityManager.find(RdsUsers.class, id);

		if (rdsUsers != null && rdsUsers.getId() > -1)

		{

			rdsUsersId = rdsUsers.getId();

			entityManager.remove(entityManager.merge(rdsUsers));

		}
		return rdsUsersId;

	}

	@Override

	public EntityWrapper<RdsUsers> updateRdsUsersByNonEmptyVal(RdsUsers rdsUsers)
	{

		EntityWrapper<RdsUsers> entityWrapper = new EntityWrapper<RdsUsers>();
		RdsUsers oldRdsUsers = null;

		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NOT_FOUND);
		entityWrapper.setMessage("Entity update :failed");
		if (rdsUsers != null && rdsUsers.getId() > -1)
		{

			RdsUsers attachedRdsUsers = entityManager.find(RdsUsers.class, rdsUsers.getId());
			if (attachedRdsUsers != null)
			{
				// TODO: if(rdsUsers.getUsername()!=null)
				oldRdsUsers = findUniqueRdsUsersBYUsername2(rdsUsers.getUsername());

				if (oldRdsUsers != null)

				{
					entityWrapper.setT(oldRdsUsers);
					entityWrapper.setHttpStatus(HttpStatus.CONFLICT);
					entityWrapper.setMessage("Returned old Entity : conflict in non-unique  rdsUsers.getUsername()");
					return entityWrapper;
				}
				// TODO: if(rdsUsers.getEmail()!=null)
				oldRdsUsers = findUniqueRdsUsersBYEmail4(rdsUsers.getEmail());

				if (oldRdsUsers != null)

				{
					entityWrapper.setT(oldRdsUsers);
					entityWrapper.setHttpStatus(HttpStatus.CONFLICT);
					entityWrapper.setMessage("Returned old Entity : conflict in non-unique  rdsUsers.getEmail()");
					return entityWrapper;
				}

				if (rdsUsers.getId() > -1)
					attachedRdsUsers.setId(rdsUsers.getId());
				if (rdsUsers.getFirstName() != null && !rdsUsers.getFirstName().equals(""))
					attachedRdsUsers.setFirstName(rdsUsers.getFirstName());
				if (rdsUsers.getLastName() != null && !rdsUsers.getLastName().equals(""))
					attachedRdsUsers.setLastName(rdsUsers.getLastName());
				if (rdsUsers.getUsername() != null && !rdsUsers.getUsername().equals(""))
					attachedRdsUsers.setUsername(rdsUsers.getUsername());
				if (rdsUsers.getPassword() != null && !rdsUsers.getPassword().equals(""))
					attachedRdsUsers.setPassword(rdsUsers.getPassword());
				if (rdsUsers.getEmail() != null && !rdsUsers.getEmail().equals(""))
					attachedRdsUsers.setEmail(rdsUsers.getEmail());
				if (rdsUsers.getAddress() != null && !rdsUsers.getAddress().equals(""))
					attachedRdsUsers.setAddress(rdsUsers.getAddress());
				if (rdsUsers.getUserType() != null && !rdsUsers.getUserType().equals(""))
					attachedRdsUsers.setUserType(rdsUsers.getUserType());
				if (rdsUsers.getPhone() != null && !rdsUsers.getPhone().equals(""))
					attachedRdsUsers.setPhone(rdsUsers.getPhone());
				if (rdsUsers.getCity() != null && !rdsUsers.getCity().equals(""))
					attachedRdsUsers.setCity(rdsUsers.getCity());
				if (rdsUsers.getCountry() != null && !rdsUsers.getCountry().equals(""))
					attachedRdsUsers.setCountry(rdsUsers.getCountry());
				if (rdsUsers.getIsActive() > -1)
					attachedRdsUsers.setIsActive(rdsUsers.getIsActive());
				if (rdsUsers.getActiveDate() != null)
					attachedRdsUsers.setActiveDate(rdsUsers.getActiveDate());
				if (rdsUsers.getEntDate() != null)
					attachedRdsUsers.setEntDate(rdsUsers.getEntDate());
				attachedRdsUsers = entityManager.merge(attachedRdsUsers);

				entityWrapper.setT(attachedRdsUsers);
				entityWrapper.setHttpStatus(HttpStatus.OK);
				entityWrapper.setMessage("Entity update :SUCCEDED ");
			}

		}

		return entityWrapper;

	}

	@Override

	public EntityWrapper<RdsUsers> updateRdsUsers(RdsUsers rdsUsers)
	{

		EntityWrapper<RdsUsers> entityWrapper = new EntityWrapper<RdsUsers>();
		RdsUsers oldRdsUsers = null;

		entityWrapper.setT(null);
		entityWrapper.setHttpStatus(HttpStatus.NOT_FOUND);
		entityWrapper.setMessage("Entity update :failed");
		if (rdsUsers != null && rdsUsers.getId() > -1)
		{

			RdsUsers attachedRdsUsers = entityManager.find(RdsUsers.class, rdsUsers.getId());
			if (attachedRdsUsers != null)
			{
				// TODO: if(rdsUsers.getUsername()!=null)
				oldRdsUsers = findUniqueRdsUsersBYUsername2(rdsUsers.getUsername());

				if (oldRdsUsers != null)

				{
					entityWrapper.setT(oldRdsUsers);
					entityWrapper.setHttpStatus(HttpStatus.CONFLICT);
					entityWrapper.setMessage("Returned old Entity : conflict in non-unique  rdsUsers.getUsername()");
					return entityWrapper;
				}
				// TODO: if(rdsUsers.getEmail()!=null)
				oldRdsUsers = findUniqueRdsUsersBYEmail4(rdsUsers.getEmail());

				if (oldRdsUsers != null)

				{
					entityWrapper.setT(oldRdsUsers);
					entityWrapper.setHttpStatus(HttpStatus.CONFLICT);
					entityWrapper.setMessage("Returned old Entity : conflict in non-unique  rdsUsers.getEmail()");
					return entityWrapper;
				}

				attachedRdsUsers.setId(rdsUsers.getId());

				attachedRdsUsers.setFirstName(rdsUsers.getFirstName());

				attachedRdsUsers.setLastName(rdsUsers.getLastName());

				attachedRdsUsers.setUsername(rdsUsers.getUsername());

				attachedRdsUsers.setPassword(rdsUsers.getPassword());

				attachedRdsUsers.setEmail(rdsUsers.getEmail());

				attachedRdsUsers.setAddress(rdsUsers.getAddress());

				attachedRdsUsers.setUserType(rdsUsers.getUserType());

				attachedRdsUsers.setPhone(rdsUsers.getPhone());

				attachedRdsUsers.setCity(rdsUsers.getCity());

				attachedRdsUsers.setCountry(rdsUsers.getCountry());

				attachedRdsUsers.setIsActive(rdsUsers.getIsActive());

				attachedRdsUsers.setActiveDate(rdsUsers.getActiveDate());

				attachedRdsUsers.setEntDate(rdsUsers.getEntDate());
				attachedRdsUsers = entityManager.merge(attachedRdsUsers);

				entityWrapper.setT(attachedRdsUsers);
				entityWrapper.setHttpStatus(HttpStatus.OK);
				entityWrapper.setMessage("Entity update :SUCCEDED ");
			}

		}

		return entityWrapper;

	}

}
