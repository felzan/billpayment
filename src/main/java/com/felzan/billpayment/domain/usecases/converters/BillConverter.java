package com.felzan.billpayment.domain.usecases.converters;

import com.felzan.billpayment.domain.entities.Bill;
import com.felzan.billpayment.domain.entities.BillToPay;
import org.springframework.stereotype.Component;

@Component
public class BillConverter {

	public Bill toBill(BillToPay billToPay) {
		return new Bill(billToPay.getName(), billToPay.getOriginalAmount(), billToPay.getDueDate(), billToPay.getPaymentDate());
	}
}
