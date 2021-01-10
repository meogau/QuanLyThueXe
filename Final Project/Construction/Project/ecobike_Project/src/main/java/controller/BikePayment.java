package controller;

import dataAccess.entities.Bike;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class BikePayment {
     Bike bike;

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public BigDecimal caculateDeposit(){
        return BigDecimal.valueOf(0);
    };
    public BigDecimal caculateFee(Timestamp timeStart, Timestamp timeEnd){
        return BigDecimal.valueOf(0);
    };


}
