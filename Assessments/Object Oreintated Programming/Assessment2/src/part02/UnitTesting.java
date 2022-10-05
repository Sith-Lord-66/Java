package part02;

import part01.Department;
import part01.Product;

public class UnitTesting {

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
        testCase4();
        testCase5();
        testCase6();
        testCase7();
        testCase8();
        testCase9();
        testCase10();
        testCase11();
        testCase12();
        testCase13();
        testCase14();
        testCase15();
        testCase16();
        testCase17();
        testCase18();
    }

    private static void testCase1() {
        // Test Case 1
        System.out.println("\n+++++++++++ Test Case 1: Product() Instance Test with quantity +++++++++++");
        // Test data - Product Instance
        Product product1 = new Product("Car", "Swift",1000,Department.OTHER,10);
        System.out.println(product1);
        System.out.println("+++++++++++++++++++++++++++++ End Test Case 1 ++++++++++++++++++++++++++++");

    }
    private static void testCase2() {
        // Test Case 2
        System.out.println("\n+++++++++++ Test Case 2: Product() Instance Test without quantity +++++++++++");
        // Test data - Product Instance
        Product product1 = new Product("Car1", "Swift1",1000,Department.OTHER);
        System.out.println(product1);
        System.out.println("++++++++++++++++++++++++++++++ End Test Case 2 ++++++++++++++++++++++++++++++");

    }
    private static void testCase3() {
        // Test Case 3
        System.out.println("\n+++++++++++ Test Case 3: addToQuantity() Test that quantity increases by amount +++++++++++");
        // Test data - Product Instance
        Product product1 = new Product("Car1", "Swift1",1000,Department.OTHER,1);
        System.out.println("Quantity 1: " + product1.getQuantity());
        product1.addToQuantity(5);
        System.out.println("Quantity 2: " + product1.getQuantity());
        System.out.println("+++++++++++++++++++++++++++++++++++++++ End Test Case 3 +++++++++++++++++++++++++++++++++++");

    }
    private static void testCase4() {
        // Test Case 4
        System.out.println("\n+++++++++++ Test Case 4: recordPurchase() Test that a purchase of an item is recorded +++++++++++");
        // Test data - Product Instance
        Product product1 = new Product("Car1", "Swift1",1000,Department.OTHER,2);
        System.out.println("Before Purchase: Quantity: " + product1.getQuantity() + " Purchases: " + product1.getPurchases());
        System.out.println("Outcome: " + product1.recordPurchase());
        System.out.println("After Purchase: Quantity: " + product1.getQuantity() + " Purchases: " + product1.getPurchases());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++ End Test Case 4 ++++++++++++++++++++++++++++++++++++++");

    }
    private static void testCase5() {
        // Test Case 5
        System.out.println("\n+++++++++++ Test Case 5: setCode() code increment Test ++++++++++");
        // Test data - Product Instance
        Product product1 = new Product("test1", "test1",1000,Department.ELECTRICAL,10);
        System.out.println("Product 1: " + product1.getCode());
        Product product2 = new Product("test2", "test2",1000,Department.COMPUTING,10);
        System.out.println("Product 2: " + product2.getCode());
        Product product3 = new Product("test3", "test3",1000,Department.OTHER,10);
        System.out.println("Product 3: " + product3.getCode());
        System.out.println("++++++++++++++++++++++++ End Test Case 5 ++++++++++++++++++++++++");
    }
    private static void testCase6() {
        // Test Case 6
        System.out.println("\n+++++++++++ Test Case 6: getCode() code retrieval Test ++++++++++");
        // Test data - Product Instance
        Product product1 = new Product("test1", "test1",1000,Department.ELECTRICAL,10);
        System.out.println("Code: " + product1.getCode());
        System.out.println("++++++++++++++++++++++++ End Test Case 6 ++++++++++++++++++++++++");
    }
    private static void testCase7() {
        // Test Case 7
        System.out.println("\n+++++++++++ Test Case 7: getPurchases() purchases retrieval Test ++++++++++");
        // Test data - Product Instance
        Product product1 = new Product("test1", "test1",1000,Department.ELECTRICAL,10);
        System.out.println("Purchases: " + product1.getPurchases());
        System.out.println("+++++++++++++++++++++++++++++ End Test Case 7 +++++++++++++++++++++++++++++");
    }
    private static void testCase8() {
        // Test Case 8
        System.out.println("\n+++++++++++ Test Case 8: getQuantity() quantity retrieval Test ++++++++++");
        // Test data - Product Instance
        Product product1 = new Product("test1", "test1",1000,Department.ELECTRICAL,10);
        System.out.println("Quantity: " + product1.getQuantity());
        System.out.println("++++++++++++++++++++++++++++ End Test Case 8 ++++++++++++++++++++++++++++");
    }
    private static void testCase9() {
        // Test Case 9
        System.out.println("\n+++++++++++ Test Case 9: getMake() make retrieval Test ++++++++++");
        // Test data - Product Instance
        Product product1 = new Product("CorrectMake", "CorrectModel",1000,Department.ELECTRICAL,10);
        System.out.println("Make: " + product1.getMake());
        System.out.println("++++++++++++++++++++++++ End Test Case 9 ++++++++++++++++++++++++");
    }
    private static void testCase10() {
        // Test Case 10
        System.out.println("\n+++++++++++ Test Case 10: getModel() Model retrieval Test ++++++++++");
        // Test data - Product Instance
        Product product1 = new Product("CorrectMake", "CorrectModel",1000,Department.ELECTRICAL,10);
        System.out.println("Model: " + product1.getModel());
        System.out.println("++++++++++++++++++++++++ End Test Case 10 ++++++++++++++++++++++++++");
    }
    private static void testCase11() {
        // Test Case 11
        System.out.println("\n+++++++++++ Test Case 11: getDepartment() Dept retrieval Test ++++++++++");
        // Test data - Product Instance
        Product product1 = new Product("test1", "test1",1000,Department.ELECTRICAL,10);
        System.out.println("Department: " + product1.getDepartment());
        System.out.println("++++++++++++++++++++++++++ End Test Case 11 ++++++++++++++++++++++++++++");
    }
    private static void testCase12() {
        // Test Case 12
        System.out.println("\n+++++++++++ Test Case 12: getPrice() price retrieval Test ++++++++++");
        // Test data - Product Instance
        Product product1 = new Product("test1", "test1",1.95,Department.ELECTRICAL,10);
        System.out.println("Price: " + product1.getPrice());
        System.out.println("++++++++++++++++++++++++ End Test Case 12 ++++++++++++++++++++++++++");
    }
    private static void testCase13() {
        // Test Case 13
        System.out.println("\n+++++++++++ Test Case 13: addToQuantity() quantity<=0 Test ++++++++++");
        // Test data
        Product product = new Product("make", "model", 1.00, Department.ELECTRICAL, -1);
        System.out.println("Entered Quantity: -1\nQuantity : " + product.getQuantity());
        System.out.println("+++++++++++++++++++++++ End Test Case 13 ++++++++++++++++++++++++++++");
    }
    private static void testCase14() {
        // Test Case 14
        System.out.println("\n+++++++++++ Test Case 14: recordPurchase() Purchase>Quantity Test ++++++++++");
        // Test data
        Product product = new Product("make", "model", 1.00, Department.ELECTRICAL, 0);
        System.out.println("Outcome: " + product.recordPurchase());
        System.out.println("+++++++++++++++++++++++++++ End Test Case 14 +++++++++++++++++++++++++++++++");
    }
    private static void testCase15() {
        // Test Case 15
        System.out.println("\n+++++++++++ Test Case 15: addToQuantity() amount<0 Test ++++++++++");
        // Test data
        Product product = new Product("make", "model", 1.00, Department.ELECTRICAL, 2);
        System.out.println("Quantity : " + product.getQuantity() + "\nEntered amount: -1");
        product.addToQuantity(-1);
        System.out.println("Quantity : " + product.getQuantity());
        System.out.println("+++++++++++++++++++++++++ End Test Case 15 +++++++++++++++++++++++");
    }
    private static void testCase16() {
        // Test Case 16
        System.out.println("\n+++++++++++ Test Case 16: Product() null make, model, incorrect price and quantity Test ++++++++++");
        // Test data
        Product product = new Product(null, null, -1.00, Department.ELECTRICAL, -1);
        System.out.println(product);
        System.out.println("++++++++++++++++++++++++++++++++++++++++ End Test Case 16 ++++++++++++++++++++++++++++++++++++++++");
    }

    private static void testCase17() {
        // Test Case 17
        System.out.println("\n+++++++++++ Test Case 17: Department() Department retrieval Test ++++++++++");
        // Test data - Department enum
        System.out.println("Department: " + Department.OTHER);
        System.out.println("+++++++++++++++++++++++++++ End Test Case 17 ++++++++++++++++++++++++++++++");
    }
    private static void testCase18() {
        // Test Case 18
        System.out.println("\n+++++++++++ Test Case 17: getLetter() letter retrieval Test ++++++++++");
        // Test data - Department enum
        System.out.println("Department getLetter: " + Department.OTHER.getLetter());
        System.out.println("+++++++++++++++++++++++++ End Test Case 18 +++++++++++++++++++++++++++");
    }


}