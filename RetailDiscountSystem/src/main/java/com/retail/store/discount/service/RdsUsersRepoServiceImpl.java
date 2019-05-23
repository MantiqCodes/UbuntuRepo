package com.retail.store.discount.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.Predicate;
import com.retail.store.discount.model.RdsUsers;
import com.retail.store.discount.repo.RdsUsersRepo;

@Service
public class RdsUsersRepoServiceImpl implements RdsUsersRepoService
{

	@Autowired
	RdsUsersRepo rdsUsersRepo;

	@Override
	public Optional<RdsUsers> findRdsUsersById(long id)
	{
		return rdsUsersRepo.findById(id);

	}

	@Override
	public List<RdsUsers> findAllRdsUsers()
	{
		return rdsUsersRepo.findAll();
	}

	@Override
	public RdsUsers findUniqueRdsUsersByUsername(String userName)
	{
		return this.rdsUsersRepo.findByUsername(userName);
	}

	@Override
	public RdsUsers findUniqueRdsUsersByEmail(String email)
	{
		return this.rdsUsersRepo.findByEmail(email);
	}

	@Override
	public RdsUsers createRdsUsers(RdsUsers rdsUsers)
	{
		return this.rdsUsersRepo.save(rdsUsers);
	}

	@Override
	public RdsUsers updateRdsUsers(RdsUsers rdsUsers)
	{
		return this.rdsUsersRepo.save(rdsUsers);
	}

	@Override
	public void deleteRdsUsers(RdsUsers rdsUsers)
	{
		this.rdsUsersRepo.delete(rdsUsers);

	}

	@Override
	public Page<RdsUsers> findAllPaginated(Predicate predicate, int page, int size, Order sortOrder, String sortColumn)
	{
		if (sortOrder.equals(Order.ASC))
			return rdsUsersRepo.findAll(predicate, PageRequest.of(page, size, Sort.by(Sort.Order.asc(sortColumn))));
		return rdsUsersRepo.findAll(predicate, PageRequest.of(page, size, Sort.by(Sort.Order.desc(sortColumn))));

	}

	@Override
	public List<RdsUsers> findAll()
	{

		return this.rdsUsersRepo.findAll();
	}

	@Override
	public boolean exists(RdsUsers rdsUsers)
	{
		if (rdsUsers != null && rdsUsers.getId() > -1)
			return rdsUsersRepo.existsById(rdsUsers.getId());
		return false;
	}

}
