package com.felzan.billpayment.domain.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Bill {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private BigDecimal originalAmount;
	private BigDecimal correctedAmount;
	private Integer daysOverdue;
	private LocalDate dueDate;
	private LocalDate paymentDate;

	public Bill(String name, BigDecimal originalAmount, LocalDate dueDate, LocalDate paymentDate) {
		this.name = name;
		this.originalAmount = originalAmount;
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
	}

	private void calculateDaysOverdue() {
		int days = Period.between(this.paymentDate, this.dueDate).getDays();
		this.daysOverdue = days < 0 ? -days : null;
	}

	public void calculateCorrectedAmount(List<Fine> fines) {
		calculateDaysOverdue();
		if (this.daysOverdue > 0) {
			Optional<Fine> fineToApply = fines.stream().filter(fine -> this.daysOverdue <= fine.getMaxDaysToApply()).findFirst();

			if (fineToApply.isPresent()) {
				Fine fine = fineToApply.get();
				this.correctedAmount = this.originalAmount.multiply(fine.getFine()).add(this.originalAmount.multiply(new BigDecimal(this.daysOverdue).multiply(fine.getFineDay())));
			}
		}
	}

}

