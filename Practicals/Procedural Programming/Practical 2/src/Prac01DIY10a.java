import java.util.Scanner;

public class Prac01DIY10a {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // the fuel efficiency represents miles per gallon
        System.out.print("Please enter the fuel efficiency in mpg: ");
        double fuelEfficiency = in.nextDouble();

        // the train price is in pounds and pence
        System.out.print("Please enter the cost of the train journey, as pounds and pence: ");
        double trainPrice = in.nextDouble();

        // the fuel cost is in pounds and pence
        System.out.print("Please enter the cost of fuel per gallon as pounds and pence: ");
        double fuelCost = in.nextDouble();

        // the car maintenance is in pence per mile
        System.out.print("Please enter the maintenance cost per mile of your car: ");
        double carMaintenance = in.nextDouble();

        // the travel distance is in miles
        System.out.print("Please enter the distance travelled: ");
        double travelDistance = in.nextDouble();

        double costOfCar = (carMaintenance * travelDistance)/100 + (travelDistance / fuelEfficiency * fuelCost);

        System.out.printf("The cost of car travel is £%.2f:\n", costOfCar);
        System.out.printf("The cost of train travel is: £%.2f\n", trainPrice);
    }
}
