import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class TestProcessTransaction {

	private TransactionAPI transactionAPI;
    private TransactionRequest transactionRequest;
	
	@BeforeEach
	void setUp() throws Exception {
		transactionAPI = new TransactionAPI();
	}

	public void test() {
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setOwner("Nguyen Van Thai");
        transactionRequest.setCardCode("4444555566667777");
        transactionRequest.setCvvCode("111");
        transactionRequest.setDateExpired("12/12");
        transactionRequest.setAmount(BigDecimal.valueOf(100));
        transactionRequest.setCommand(Config.PROCESS_PAY);
        transactionRequest.setCreateAt(new Date());
        transactionRequest.setTransactionContent(Config.DEFAULT_CONTENT);
		
        JSONObject jsonResult = transactionAPI.processTransaction(transactionRequest);
        boolean isValided = false;
        String errorCode = jsonResult.getString("errorCode");
        if(errorCode.equals("00"))     isValided = false;
        else  if(errorCode.equals("01")) isValided = false;
        else  if(errorCode.equals("02")) isValided = false;
        else  if(errorCode.equals("03")) isValided = false;
        else  if(errorCode.equals("04")) isValided = false;
        else isValided = true;
        
        assertEquals(true, isValided);
	}

}
