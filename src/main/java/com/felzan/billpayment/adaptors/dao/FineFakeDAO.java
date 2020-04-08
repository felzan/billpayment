package com.felzan.billpayment.adaptors.dao;

import com.felzan.billpayment.domain.entities.Fine;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class FineFakeDAO {

	public List<Fine> getFines() {
		List<Fine> fines = new ArrayList<>();

		Fine untilThreeDays = new Fine(3, new BigDecimal("1.02"), new BigDecimal("0.0001"));
		Fine untilFiveDays = new Fine(5, new BigDecimal("1.03"), new BigDecimal("0.0002"));
		Fine max = new Fine(Integer.MAX_VALUE, new BigDecimal("1.05"), new BigDecimal("0.0003"));

		fines.add(untilThreeDays);
		fines.add(untilFiveDays);
		fines.add(max);

		return fines;
	}
}
