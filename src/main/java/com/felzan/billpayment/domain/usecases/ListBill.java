package com.felzan.billpayment.domain.usecases;

import com.felzan.billpayment.ports.IListBill;
import com.felzan.billpayment.domain.entities.Bill;
import com.felzan.billpayment.domain.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListBill implements IListBill {

	private final BillRepository repository;

	@Override
	public List<Bill> listBill() {
		return (List<Bill>) repository.findAll();
	}
}
