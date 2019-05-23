package com.retail.store.discount.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.retail.store.discount.model.RdsInventory;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

@Repository

public interface RdsInventoryRepo extends JpaRepository<RdsInventory, Long>, QuerydslPredicateExecutor<RdsInventory>

{

}
