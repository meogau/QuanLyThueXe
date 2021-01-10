package dataAccess.entities;

public class ElectricBike extends Bike {
    private float battery;


    public float getBattery() {
        return battery;
    }


    public void setBattery(float battery) {
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "ElectricBike{" +
                "battery=" + battery +
                '}';
    }
}
