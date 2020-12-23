package test.DAO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import dataAccess.DAO.CardDAO;

class CheckCardExistTest {
 CardDAO cardDAO ;
	@BeforeEach
	void setUp() throws Exception {
		cardDAO = new CardDAO();
	}
	@ParameterizedTest
	@CsvSource({
		"111111111,false",
		"211111,false",
		"32222222222222,false",
		"118609_group16_2020,true"
		
	})
	@Test
	void test(String cardNumber,boolean expected) {
		boolean rs = cardDAO.checkCardExist(cardNumber);
		assertEquals(expected,rs);
	}

}
