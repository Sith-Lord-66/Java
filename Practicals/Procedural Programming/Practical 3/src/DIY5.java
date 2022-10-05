import java.util.Scanner;

public class DIY5 {

    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        System.out.println("Please enter your salary amount");
        double salary = inp.nextDouble();

        inp.close();

        if (salary > 9000 && salary < 20000) {
            salary = salary * 0.85;
            System.out.printf("Salary after tax is: %.2f", salary);
        }
        else if (salary > 20000) {
            salary = salary *0.75;
            System.out.printf("Salary after tax is: %.2f", salary);
        }
        else {
            System.out.println("You dont have to pay tax!");
        }

    }
}
