package controller;

import API.Config;
import API.TransactionAPI;
import API.TransactionRequest;
import dataAccess.DAO.CardDAO;
import dataAccess.DAO.TransactionDAO;
import dataAccess.entities.Card;
import javafx.scene.control.Alert.AlertType;

import org.json.JSONObject;
import org.openjfx.Dialog;
import org.openjfx.PaymentMessageController;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

public class PaymentController {

	private TransactionAPI transactionAPI;
	private PaymentMessageController anouceController = new PaymentMessageController();
	private TransactionDAO transactionDAO = new TransactionDAO();
	private CardDAO cardDAO = new CardDAO();

	public int processPay(Card card, BigDecimal amount) throws IOException {
		// check card exist and card status
		boolean cardExist = cardDAO.checkCardExist(card.getCardNumber());
		int cardStatus = cardDAO.checkCardStatus(card.getCardNumber());
		Dialog dialog;
		if (cardStatus == 1) {
			System.out.println("Card da duoc su dung");
			dialog = new Dialog("Error", "Card đã được sử dụng", AlertType.INFORMATION) {

//				@Override
//				public void doSomething() {
//					// TODO Auto-generated method stub
//
//				}
			};
			dialog.show();
			return 0;
		} else {
			// add information to transaction request
			TransactionRequest transactionRequest = new TransactionRequest();
			transactionRequest.setOwner(card.getCardHolder());
			transactionRequest.setCardCode(card.getCardNumber());
			transactionRequest.setCvvCode(card.getSecurityCode());
			transactionRequest.setDateExpired(card.getExpirationDate());
			transactionRequest.setAmount(BigDecimal.valueOf(100));
			transactionRequest.setCommand(Config.PROCESS_PAY);
			transactionRequest.setCreateAt(new Date());
			transactionRequest.setTransactionContent(Config.DEFAULT_CONTENT);
			JSONObject jsonResult = (transactionAPI.processTransaction(transactionRequest));
			System.out.println(jsonResult.toString());
			// handle error code
			String errorCode = jsonResult.getString("errorCode");
			
			if (errorCode.equals("00")) {
				// save card and update status
				int cardId = 0;
				if (!cardExist) {
					System.out.println("Card chua co trong db");
					cardId = cardDAO.createCard(card.getCardNumber(), card.getCardHolder(), card.getExpirationDate(),
							card.getSecurityCode());
				} else {
					cardId = cardDAO.findCardByCardNumber(card.getCardNumber()).getId();
				}
				cardDAO.updateCardStatus(card.getCardNumber(), 1);

				// save transaction
				transactionDAO.saveTransaction(cardId, amount, Config.PROCESS_PAY);

				// anouceController.show();
				
				return cardId;
			} else if (errorCode.equals("01")) {
				dialog = new Dialog("Error", "The khong hop le", AlertType.INFORMATION) {

//					@Override
//					public void doSomething() {
//						// TODO Auto-generated method stub
//
//					}
				};
				dialog.show();
			} else if (errorCode.equals("02")) {
				dialog = new Dialog("Error", "The khong du so du", AlertType.INFORMATION) {

//					@Override
//					public void doSomething() {
//						// TODO Auto-generated method stub
//
//					}
				};
				dialog.show();
			} else if (errorCode.equals("03")) {
				dialog = new Dialog("Error", "Server dang loi", AlertType.INFORMATION) {

					
				};
				dialog.show();
			} else if (errorCode.equals("04")) {
				dialog = new Dialog("Error", "Giao dich bi nghi ngo", AlertType.INFORMATION) {

//					@Override
//					public void doSomething() {
//						// TODO Auto-generated method stub
//
//					}
				};
				dialog.show();
			}
			
		}

		return 0;
	}
	
	public int processRefund(int cardId, BigDecimal amount, boolean refundStatus) throws IOException {
        Card card = cardDAO.findCardById(cardId);

          //add information to transaction request
          TransactionRequest transactionRequest = new TransactionRequest();
          transactionRequest.setOwner(card.getCardHolder());
          transactionRequest.setCardCode(card.getCardNumber());
          transactionRequest.setCvvCode(card.getSecurityCode());
          transactionRequest.setDateExpired(card.getExpirationDate());
          transactionRequest.setAmount(amount);
          transactionRequest.setCreateAt(new Date());
          transactionRequest.setTransactionContent(Config.DEFAULT_CONTENT);
          String command ;
          if(refundStatus) command = (Config.PROCESS_REFUND);
          else command = (Config.PROCESS_PAY);
          transactionRequest.setCommand(command);

          JSONObject jsonResult = (transactionAPI.processTransaction(transactionRequest));
          System.out.println(jsonResult.toString());
          // handle error code
          String errorCode = jsonResult.getString("errorCode");
          if(errorCode.equals("00")) {
              cardDAO.updateCardStatus(card.getCardNumber(),0);

              //save transaction
              transactionDAO.saveTransaction(card.getId(),amount,command);
              return 1;
          }
          else  if(errorCode.equals("01")) System.out.println("The ko hop le");
          else  if(errorCode.equals("02")) System.out.println("The ko du so du");
          else  if(errorCode.equals("03")) System.out.println("Server dang loi");
          else  if(errorCode.equals("04")) System.out.println("Giao dich bi nghi ngo");



      return 0;
  }

}
