package com.retail.store.discount.repo;

import com.retail.store.discount.model.RdsInvoice;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

@Repository

public interface RdsInvoiceRepo extends JpaRepository<RdsInvoice, Long>, QuerydslPredicateExecutor<RdsInvoice>

{

}
