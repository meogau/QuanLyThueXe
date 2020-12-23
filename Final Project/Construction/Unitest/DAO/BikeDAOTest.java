package test.DAO;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import dataAccess.DAO.BikeDAO;
import dataAccess.entities.Bike;

class CheckBikeTest {
	BikeDAO bikeDAO ;

	@BeforeEach
	void setUp() throws Exception {
		bikeDAO = new BikeDAO();
		
	}
	@ParameterizedTest
	@CsvSource({
		"1,1",
		"2,0",
		"3,0",
		"5,0"
		
	})
	@Test
	void test(int bikeId, int status) {
		int bikeStatus = bikeDAO.getBikeStatus(bikeId);
		assertEquals(status,bikeStatus);
	}

}
