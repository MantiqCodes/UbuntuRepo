package com.retail.store.discount.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.Predicate;
import com.retail.store.discount.model.RdsUsers;

public interface RdsUsersRepoService
{
	public Optional<RdsUsers> findRdsUsersById(long id);

	public List<RdsUsers> findAllRdsUsers();

	public RdsUsers findUniqueRdsUsersByUsername(String username);

	public RdsUsers findUniqueRdsUsersByEmail(String email);

	public RdsUsers createRdsUsers(RdsUsers rdsUsers);

	public RdsUsers updateRdsUsers(RdsUsers rdsUsers);

	public boolean exists(RdsUsers rdsUsers);

	public void deleteRdsUsers(RdsUsers rdsUsers);

	public List<RdsUsers> findAll();

	Page<RdsUsers> findAllPaginated(Predicate predicate, int page, int size, Order sortOrder, String sortColumn);

}
