package test.Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.PaymentController;
import dataAccess.entities.Card;

class ProcessPayTest {
PaymentController paymentController;
	@BeforeEach
	void setUp() throws Exception {
		paymentController = new PaymentController();
	}

	@Test
	void test() throws IOException {
		Card card = new Card();
		card.setId(1);
		card.setCardHolder("Group 16");
		card.setCardNumber("118609_group16_2020");
		card.setSecurityCode("601");
		card.setStatus(0);
		card.setExpirationDate("1125");
		int a =1234;
		assertEquals(1, paymentController.processPay(card, BigDecimal.valueOf(a)));
	}

}
