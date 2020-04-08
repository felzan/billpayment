package com.felzan.billpayment.utils;

import com.felzan.billpayment.domain.entities.Bill;
import com.felzan.billpayment.domain.entities.BillToPay;
import com.felzan.billpayment.domain.entities.Fine;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class MockUtils {

	public static List<Fine> fines() {
		Fine untilThreeDays = new Fine(3, new BigDecimal("1.1"), new BigDecimal("0.001"));
		Fine max = new Fine(Integer.MAX_VALUE, new BigDecimal("1.2"), new BigDecimal("0.002"));
		return List.of(untilThreeDays, max);
	}

	public static BillToPay billToPay(){
		return new BillToPay("", new BigDecimal("100"), LocalDate.now(), LocalDate.now().plusDays(1));
	}

	public static Bill bill(){
		return new Bill("", new BigDecimal("100"), LocalDate.now(), LocalDate.now().plusDays(1));
	}

	public static Bill billCorrected(){
		Bill bill = bill();
		bill.setCorrectedAmount(new BigDecimal("110.100"));
		bill.setDaysOverdue(1);
		return bill;
	}
}
