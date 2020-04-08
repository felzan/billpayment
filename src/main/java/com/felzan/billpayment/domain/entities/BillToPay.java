package com.felzan.billpayment.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class BillToPay {

	private String name;
	private BigDecimal originalAmount;
	private LocalDate dueDate;
	private LocalDate paymentDate;

}
