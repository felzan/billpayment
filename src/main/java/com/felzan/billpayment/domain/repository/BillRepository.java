package com.felzan.billpayment.domain.repository;

import com.felzan.billpayment.domain.entities.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {
}
