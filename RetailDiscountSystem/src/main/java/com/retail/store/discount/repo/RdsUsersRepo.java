package com.retail.store.discount.repo;

import com.retail.store.discount.model.RdsUsers;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

@Repository

public interface RdsUsersRepo extends JpaRepository<RdsUsers, Long>, QuerydslPredicateExecutor<RdsUsers>
{
	RdsUsers findByUsername(String userName);

	RdsUsers findByEmail(String userName);

	RdsUsers findByUsernameAndEmail(String userName, String email);

}
