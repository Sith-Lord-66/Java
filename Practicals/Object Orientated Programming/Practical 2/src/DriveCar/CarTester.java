package DriveCar;

public class CarTester {

    public static void main(String[] args) {
        Car suzukiSwift = new Car(10);
        System.out.println("Max Capacity:\t" + suzukiSwift.getTankCapacity());
        System.out.println("Fuel:\t\t\t" + suzukiSwift.getFuel());
        suzukiSwift.addFuel(7);
        System.out.println("Fuel Cost:\t\t" + calculateFuelCost(2));
        System.out.println("Fuel:\t\t\t" + suzukiSwift.getFuel());
        suzukiSwift.drive(15);
        System.out.println("Fuel Cost:\t\t" + calculateFuelCost(0.6));
        System.out.println("Fuel:\t\t\t" + suzukiSwift.getFuel());
        fuelFullTank(suzukiSwift);
        System.out.println("Fuel:\t\t\t" + suzukiSwift.getFuel());
    }
    public static void fuelFullTank(Car carName){
        double max = carName.getTankCapacity();
        double fuel = carName.getFuel();
        double addFuel = max - fuel;
        System.out.println("Fuel Cost:\t\t" + calculateFuelCost(addFuel));
        carName.addFuel(addFuel);
    }
    public static double costConverter(){
        final double costPerLitre = 128.8f;
        double costPerGallon = costPerLitre * 4.546f;
        costPerGallon = costPerGallon/100;
        return costPerGallon;
    }
    public static double calculateFuelCost(double gallons){
        final double fuelCost = costConverter();
        return fuelCost * gallons;

    }
}
