package mobileApp;

public class MobileTester {

    public static void main(String[] args) {

        Mobile jamesPhone = new Mobile ("PAYG", "Iphone XR", "07946119013");
        System.out.println("Account type: " + jamesPhone.getAccType());
        System.out.println("Device : " + jamesPhone.getDevice());
        System.out.println("Number : " + jamesPhone.getNumber());
        System.out.println("Balance : " + jamesPhone.getBalance());

        jamesPhone.addCredit(20.00);
        System.out.println("\nCredit Successful for \n Number: " + jamesPhone.getNumber()
                + "\n Balance: " + jamesPhone.getBalance());
        jamesPhone.makeCall(20);
        System.out.println("\nCall made for \n Number: " + jamesPhone.getNumber()
                + "\n Balance: " + jamesPhone.getBalance());
        jamesPhone.sendText(5);
        System.out.println("\nText sent for \n Number: " + jamesPhone.getNumber()
                + "\n Balance: " + jamesPhone.getBalance());
        jamesPhone.useData(10);
        System.out.println("\nData used for \n Number: " + jamesPhone.getNumber()
                + "\n Balance: " + jamesPhone.getBalance());

        Mobile jimMobile = new Mobile("PAYG", "iPhone 7", "07712442442");
        System.out.println("\nAccount type: " + jimMobile.getAccType());
        System.out.println("Device : " + jimMobile.getDevice());
        System.out.println("Number : " + jimMobile.getNumber());
        System.out.println("Balance : " + jimMobile.getBalance());


        jimMobile.addCredit(10.00);
        System.out.println("\nCredit Successful for \n Number: " + jimMobile.getNumber()
                + "\n Balance: " + jimMobile.getBalance());
        jimMobile.makeCall(15);
        System.out.println("\nCall made for \n Number: " + jimMobile.getNumber()
                + "\n Balance: " + jimMobile.getBalance());
        jimMobile.sendText(2);
        System.out.println("\nText sent for \n Number: " + jimMobile.getNumber()
                + "\n Balance: " + jimMobile.getBalance());
    }
}
