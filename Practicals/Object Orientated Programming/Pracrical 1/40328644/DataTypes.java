import java.util.Scanner;

public class DataTypes {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer followed by a double:");
        while(!input.hasNextInt()){
            input.next();
            System.out.print("Incorrect Value: ");
        }
        int iNum = input.nextInt(); // read an integer
        while(!input.hasNextDouble()){
            input.next();
            System.out.print("Incorrect Value: ");
        }
        double dNum = input.nextDouble(); // read a double

        System.out.println("Integer: "+iNum+" Double: "+dNum);
        input.close();
    }

} 