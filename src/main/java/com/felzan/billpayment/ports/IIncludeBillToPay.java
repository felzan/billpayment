package com.felzan.billpayment.ports;

import com.felzan.billpayment.domain.entities.Bill;
import com.felzan.billpayment.domain.entities.BillToPay;
import org.springframework.stereotype.Component;

@Component
public interface IIncludeBillToPay {

	Bill includeBillToPay(BillToPay billToPay);
}
