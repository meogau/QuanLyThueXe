package controller;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class StandBikePayment extends BikePayment {
    @Override
    public BigDecimal caculateDeposit() {
        float deposit = (float) (bike.getPrice()*0.4f);
        return BigDecimal.valueOf(deposit);
    }

    @Override
    public BigDecimal caculateFee(Timestamp timeStart, Timestamp timeEnd) {
        Long timeUsing = Math.abs(timeStart.getTime() - timeEnd.getTime())/(60*1000);
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
        return BigDecimal.valueOf(result);
    }
}
