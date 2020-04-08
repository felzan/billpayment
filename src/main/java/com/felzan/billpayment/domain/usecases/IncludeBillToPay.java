package com.felzan.billpayment.domain.usecases;

import com.felzan.billpayment.adaptors.dao.FineFakeDAO;
import com.felzan.billpayment.domain.usecases.converters.BillConverter;
import com.felzan.billpayment.ports.IIncludeBillToPay;
import com.felzan.billpayment.domain.entities.Bill;
import com.felzan.billpayment.domain.entities.BillToPay;
import com.felzan.billpayment.domain.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncludeBillToPay implements IIncludeBillToPay {

	private final BillRepository billRepository;
	private final BillConverter converter;
	private final FineFakeDAO fineDAO;

	@Override
	public Bill includeBillToPay(BillToPay billToPay) {
		Bill bill = converter.toBill(billToPay);
		bill.calculateCorrectedAmount(fineDAO.getFines());
		return billRepository.save(bill);
	}
}
