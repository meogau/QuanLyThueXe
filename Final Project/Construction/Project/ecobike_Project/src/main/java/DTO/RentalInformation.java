package DTO;

import java.math.BigDecimal;
import java.util.Date;
// tu object nay ong render ra cai trang day 

public class RentalInformation {
    BigDecimal deposit;
    BigDecimal rentalFee;
    float usingTime;
    String bikeName;
	public BigDecimal getDeposit() {
		return deposit;
	}
	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}
	public BigDecimal getRentalFee() {
		return rentalFee;
	}
	public void setRentalFee(BigDecimal rentalFee) {
		this.rentalFee = rentalFee;
	}
	public float getUsingTime() {
		return usingTime;
	}
	public void setUsingTime(float usingTime) {
		this.usingTime = usingTime;
	}
	public String getBikeName() {
		return bikeName;
	}
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
    
    

}
