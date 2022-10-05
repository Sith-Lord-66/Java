package DriveCar;

public class Car {

    private double fuelEfficiency, fuel, maxCapacity;

    public Car(double maxCapacity) {
        this.fuelEfficiency = 25;
        this.fuel = 0;
        this.maxCapacity = maxCapacity;
    }

    public void drive(double distance){
        double fuelUsed;
        fuelUsed = distance/fuelEfficiency;
        fuel -= fuelUsed;
    }
    public double getTankCapacity(){
        return maxCapacity;
    }
    public double getFuel() {
        return fuel;
    }
    public void addFuel(double addGallons) {
        fuel += addGallons;
    }

}
