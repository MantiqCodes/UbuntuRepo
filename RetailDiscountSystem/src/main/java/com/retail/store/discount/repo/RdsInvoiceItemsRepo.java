package com.retail.store.discount.repo;

import org.springframework.stereotype.Repository;
import com.retail.store.discount.model.RdsInvoiceItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

@Repository

public interface RdsInvoiceItemsRepo
		extends JpaRepository<RdsInvoiceItems, Long>, QuerydslPredicateExecutor<RdsInvoiceItems>

{

}
