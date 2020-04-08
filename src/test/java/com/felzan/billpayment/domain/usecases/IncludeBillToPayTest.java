package com.felzan.billpayment.domain.usecases;

import com.felzan.billpayment.adaptors.dao.FineFakeDAO;
import com.felzan.billpayment.domain.entities.Bill;
import com.felzan.billpayment.domain.entities.BillToPay;
import com.felzan.billpayment.domain.repository.BillRepository;
import com.felzan.billpayment.domain.usecases.converters.BillConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.felzan.billpayment.utils.MockUtils.bill;
import static com.felzan.billpayment.utils.MockUtils.billCorrected;
import static com.felzan.billpayment.utils.MockUtils.billToPay;
import static com.felzan.billpayment.utils.MockUtils.fines;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IncludeBillToPayTest {

	@InjectMocks
	private IncludeBillToPay includeBillToPay;
	@Mock
	private BillRepository billRepository;
	@Mock
	private FineFakeDAO fineFakeDAO;
	@Mock
	private BillConverter billConverter;

	@Test
	void includeBillToPay() {
		Bill bill = bill();
		when(billConverter.toBill(billToPay())).thenReturn(bill);
		when(fineFakeDAO.getFines()).thenReturn(fines());
		when(billRepository.save(bill)).thenReturn(bill);

		bill.calculateCorrectedAmount(fines());
		includeBillToPay.includeBillToPay(billToPay());

		verify(billConverter, times(1)).toBill(any(BillToPay.class));
	}
}
