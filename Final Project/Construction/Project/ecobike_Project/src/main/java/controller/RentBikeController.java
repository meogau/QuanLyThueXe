package controller;

import API.Config;
import DTO.RentalInformation;
import dataAccess.DAO.BikeDAO;
import dataAccess.DAO.RentalDAO;
import dataAccess.entities.Bike;
import dataAccess.entities.Card;
import dataAccess.entities.Rental;
import dataAccess.entities.StandBike;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public class RentBikeController {

    private static RentalDAO rentalDAO = new RentalDAO();
    private static BikeDAO bikeDAO = new BikeDAO();
    private PaymentController paymentController = new PaymentController();
    private BikePayment bikePayment;

    public void setBikePayment(BikePayment bikePayment) {
        this.bikePayment = bikePayment;
    }

    public  int rentBikeProcess(Bike bike , Card card) throws IOException {

        if (bike.getStatus() == 1) return Config.BIKE_HAS_BEEN_RENTED;
        //rent bike
        bikePayment.setBike(bike);
        BigDecimal amount = bikePayment.caculateDeposit();
        int cardId =  paymentController.processPay(card,amount);
        if(cardId!=0){
            //create Rental
            int rentailId= rentalDAO.createRental(bike.getId(),cardId);
            //update bike status
           bikeDAO.updateBikeStatus(bike,1);
            return rentailId;
        }
        else {
            return 0;
       }
    }

    public Bike getBikeRental(int rentalId) throws SQLException {
        Rental rental = rentalDAO.findRentalById(rentalId);
        return bikeDAO.findBikeById(rental.getBikeId());
    }




    public RentalInformation returnBike(int rentalId) throws IOException, SQLException {
        rentalDAO.endRentalBike(rentalId);

        //get bike and rental
        Rental rental = rentalDAO.findRentalById(rentalId);
        Bike bike = bikeDAO.findBikeById(rental.getBikeId());
        bikePayment.setBike(bike);
        //caculate fee
        BigDecimal rentalFee = bikePayment.caculateFee(rental.getStartTime(),rental.getEndTime());
        //caculate refund
        BigDecimal deposit = bikePayment.caculateDeposit();
        float refund =0f;
        boolean refundStatus = false;
        if(deposit.floatValue()>rentalFee.floatValue()){
            refund = deposit.floatValue() - rentalFee.floatValue();
            refundStatus = true;

        }
        else {
            refund =  rentalFee.floatValue() - deposit.floatValue() ;
        }
        //refund money
            paymentController.processRefund(rental.getCardId(),BigDecimal.valueOf(refund),refundStatus);
        // update bike status
        bikeDAO.updateBikeStatus(bike,0);
        //return data
        RentalInformation rentalInformation = new RentalInformation();
        rentalInformation.setDeposit(deposit);
        rentalInformation.setRentalFee(rentalFee);
        rentalInformation.setBikeName(bike.getName());
        rentalInformation.setUsingTime(Math.abs(rental.getStartTime().getTime() - rental.getEndTime().getTime())/(60*1000));
        return rentalInformation;
    }




}
