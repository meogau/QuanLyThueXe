package controller;

import API.Config;
import DTO.RentalInformation;
import dataAccess.DAO.BikeDAO;
import dataAccess.DAO.RentalDAO;
import dataAccess.entities.Bike;
import dataAccess.entities.Card;
import dataAccess.entities.Rental;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class RentBikeController {

    private static RentalDAO rentalDAO = new RentalDAO();
    private static BikeDAO bikeDAO = new BikeDAO();
    private PaymentController paymentController = new PaymentController();

    public  int rentBikeProcess(int bikeId , Card card) throws IOException {
        Bike bike = bikeDAO.getBikeById(bikeId);
        //check bike exist
        if (bike.equals(null)) return Config.BIKE_NULL;
        //check bike ready or not
        if (bikeDAO.getBikeStatus(bikeId) == 1) return Config.BIKE_HAS_BEEN_RENTED;
        //rent bike
        BigDecimal amount = caculateDeposit(bike);
        int cardId =  paymentController.processPay(card,amount);
        if(cardId!=0){
        	System.out.println("vao day --------------");
            //create Rental
            int rentailId= rentalDAO.createRental(bikeId,cardId);
            //update bike status
            bikeDAO.updateStatus(bikeId,1);
            return rentailId;
        }
        else {
            return 0;
        }
    }

    public Bike getBikeRental(int rentalId){
        Rental rental = rentalDAO.findRentalById(rentalId);
        return bikeDAO.getBikeById(rental.getBikeId());
    }
    public BigDecimal caculateDeposit(Bike bike){
        float deposit = (float) (bike.getPrice()*0.4);
        if(bike.getType()==1) return BigDecimal.valueOf(deposit);
        else return BigDecimal.valueOf((deposit*1.5));
    }



    public RentalInformation returnBike(int rentalId) throws IOException {
        rentalDAO.endRentalBike(rentalId);

        //get bike and rental
        Rental rental = rentalDAO.findRentalById(rentalId);
        Bike bike = bikeDAO.getBikeById(rental.getBikeId());
        //caculate fee
        BigDecimal rentalFee = caculateRentalFee(bike.getType(),rental.getStartTime(),rental.getEndTime());
        //caculate refund
        BigDecimal deposit = caculateDeposit(bike);
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
        bikeDAO.updateStatus(bike.getId(),0);

        //return data
        RentalInformation rentalInformation = new RentalInformation();
        rentalInformation.setDeposit(deposit);
        rentalInformation.setRentalFee(rentalFee);
        rentalInformation.setBikeName(bike.getName());
        rentalInformation.setUsingTime(Math.abs(rental.getStartTime().getTime() - rental.getEndTime().getTime())/(60*1000));
        return rentalInformation;
    }

    public BigDecimal caculateRentalFee(int bikeType , Timestamp timeStart, Timestamp timeEnd){
        Long timeUsing = Math.abs(timeStart.getTime() - timeEnd.getTime())/(60*1000);
        System.out.println("Using time = " + timeUsing);
        Float result = null;
        if(timeUsing <= 10) {
            result = 0.0f;
        }
        else if(timeUsing > 10 && timeUsing <= 30){
            result = 10000.0f;
        }else if(timeUsing > 30){
            Integer extra = (int) Math.ceil((timeUsing - 30) / 15.0f);
            result = 10000.0f + 3000.0f * extra;
        }

        if (bikeType!=1) {
            result *= 1.5f;
        }
        return BigDecimal.valueOf(result);
    }


}
