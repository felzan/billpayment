package com.felzan.billpayment.adaptors.http;

import com.felzan.billpayment.domain.entities.Bill;
import com.felzan.billpayment.domain.entities.BillToPay;
import com.felzan.billpayment.ports.IIncludeBillToPay;
import com.felzan.billpayment.ports.IListBill;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("bills")
@RequiredArgsConstructor
public class BillController {

	private final IIncludeBillToPay includeBillToPay;
	private final IListBill listBill;

	@PostMapping
	public ResponseEntity<Bill> postBill(@RequestBody BillToPay billToPay){
		return ResponseEntity.status(HttpStatus.CREATED).body(includeBillToPay.includeBillToPay(billToPay));
	}

	@GetMapping
	public ResponseEntity<?> listAll() {
		return ResponseEntity.ok(listBill.listBill());
	}
}
