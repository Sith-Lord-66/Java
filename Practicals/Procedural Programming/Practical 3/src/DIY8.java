import java.util.Scanner;

public class DIY8 {

    public static void main(String[] args) {

        int base = 11000;

        Scanner inp = new Scanner(System.in);

        System.out.println("BASIC CARL MODEL COSTS: £" + base);
        System.out.println("It includes:\n-1.2l petrol engine\n-Silver Colour");
        System.out.println("Would you like to upgrade the engine?\ny for yes\nn for no");
        String temp = inp.next();

        if (temp.equals("y")) {
            System.out.println("What engine would you like to upgrade to?\na. 1.4l petrol (add £200)\nb. 1.6l petrol (add £300)\nc. 1.8l petrol (add £400)");
            temp = inp.next();
            switch (temp) {
                case ("a"): base = base + 200; break;
                case ("b"): base = base + 300; break;
                case ("c"): base = base + 400; break;
            }
        }

        System.out.println("Would you like to change the car colour?\ny for yes\nn for no");
        temp = inp.next();
        if (temp.equals("y")) {
            System.out.println("Select from the colour options: \na. Red (add £200)\na. Red (add £200)\nc. White (add £350)");
            temp = inp.next();

            switch (temp) {
                case ("a"): base = base + 200; break;
                case ("b"): base = base + 200; break;
                case ("c"): base = base + 350; break;
            }

            System.out.println("Would you like heated seats (£500)?\ny for yes\nn for no");
            temp = inp.next();
            if (temp.equals("y")) {
                base = base + 500;
            }

            System.out.println("Would you like air conditioning (£500)?\ny for yes\nn for no");
            temp = inp.next();
            if (temp.equals("y")) {
                base = base + 500;
            }

            System.out.println("Would you like parking sensors? (£100)?\ny for yes\nn for no");
            temp = inp.next();
            if (temp.equals("y")) {
                base = base + 100;
            }

            System.out.printf("\nYour total car cost is: £%d", base);

            inp.close();
        }
    }
}

