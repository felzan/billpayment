package com.felzan.billpayment.domain.entities;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.felzan.billpayment.utils.MockUtils.fines;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class BillTest {

	@Test
	public void shouldCalculateCorrectedAmount() {
		Bill bill = new Bill("New payment", new BigDecimal("100"), LocalDate.now(), LocalDate.now().plusDays(3));
		bill.calculateCorrectedAmount(fines());
		assertThat(bill.getCorrectedAmount(), comparesEqualTo(new BigDecimal("110.3")));
	}

}
