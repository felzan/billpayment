package com.felzan.billpayment.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fine {

	private Integer maxDaysToApply;
	private BigDecimal fine;
	private BigDecimal fineDay;
}
