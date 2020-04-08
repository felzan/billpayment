package com.felzan.billpayment.ports;

import com.felzan.billpayment.domain.entities.Bill;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IListBill {

	List<Bill> listBill();
}
