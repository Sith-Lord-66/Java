package part02;

import part01.Department;
import part01.Product;
import part01.Warehouse;

public class IntegrationTesting {

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
    }


    private static void testCase1() {
        // Test Case 1
        System.out.println("\n+++++++++++ Test Case 1: addProduct() Product creation Test +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        System.out.println(ware.addProduct("TestMake","TestModel",1,Department.ELECTRICAL));
        System.out.println(ware);
        System.out.println("+++++++++++++++++++++++++++++ End Test Case 1 ++++++++++++++++++++++++++++");

    }
    private static void testCase2() {
        // Test Case 2
        System.out.println("\n+++++++++++ Test Case 2: addProduct() Product creation Test with same make and model +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        System.out.println(ware.addProduct("TestMake","TestModel",1,Department.ELECTRICAL));
        System.out.println(ware.addProduct("TestMake","TestModel",1,Department.ELECTRICAL));
        System.out.println(ware);
        System.out.println("+++++++++++++++++++++++++++++++++++++++ End Test Case 2 +++++++++++++++++++++++++++++++++++++++++");

    }
    private static void testCase3() {
        // Test Case 3
        System.out.println("\n+++++++++++ Test Case 3: deleteProduct() Test deletion of product +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        ware.addProduct("TestMake","TestModel",1,Department.ELECTRICAL);
        System.out.println("Deleted: " + ware.deleteProduct("E0003"));
        System.out.println("++++++++++++++++++++++++++++++ End Test Case 3 +++++++++++++++++++++++++++++++");

    }
    private static void testCase4() {
        // Test Case 4
        System.out.println("\n+++++++++++ Test Case 4: deleteProduct() Test deletion of product with incorrect code +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        ware.addProduct("TestMake","TestModel",1,Department.ELECTRICAL);
        System.out.println("Deleted: " + ware.deleteProduct("E0001"));
        System.out.println("++++++++++++++++++++++++++++++++++++++++ End Test Case 4 ++++++++++++++++++++++++++++++++++++++++");

    }
    private static void testCase5() {
        // Test Case 5
        System.out.println("\n+++++++++++ Test Case 6: getAllProducts() Test retrieval of products in the warehouse +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        ware.addProduct("TestMake","TestModel",1,Department.ELECTRICAL);

        for(Product prod: ware.getAllProducts()){
            System.out.println("\n" + prod);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++ End Test Case 5 ++++++++++++++++++++++++++++++++++++++++");

    }
    private static void testCase6() {
        // Test Case 6
        System.out.println("\n+++++++++++ Test Case 6: getAllProducts() Test when no products present in warehouse +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        for(Product prod: ware.getAllProducts()){
            System.out.println("\n" + prod);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++ End Test Case 6 +++++++++++++++++++++++++++++++++++++++");
    }
    private static void testCase7() {
        // Test Case 7
        System.out.println("\n+++++++++++ Test Case 7: restock() Test addition of amount to quantity +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        ware.addProduct("TestMake","TestModel",1,Department.ELECTRICAL);

        System.out.println("Quantity added? - " + ware.restock("E0006",3) + " Entered quantity: 3");
        System.out.println(ware);
        System.out.println("++++++++++++++++++++++++++++++++ End Test Case 7 ++++++++++++++++++++++++++++++++");

    }
    private static void testCase8() {
        // Test Case 8
        System.out.println("\n+++++++++++ Test Case 8: restock() Test addition of amount<0 to quantity +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        ware.addProduct("TestMake","TestModel",1,Department.ELECTRICAL);

        System.out.println("Quantity added? - " + ware.restock("E0007",-1) + " Entered quantity: -1");
        System.out.println(ware);
        System.out.println("++++++++++++++++++++++++++++++++ End Test Case 8 ++++++++++++++++++++++++++++++++");

    }
    private static void testCase9() {
        // Test Case 9
        System.out.println("\n+++++++++++ Test Case 9: restock() Test addition of amount>100 to quantity +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        ware.addProduct("TestMake","TestModel",1,Department.ELECTRICAL);

        System.out.println("Quantity added? - " + ware.restock("E0008",100) + " Entered quantity: 100");
        System.out.println(ware);
        System.out.println("++++++++++++++++++++++++++++++++ End Test Case 9 ++++++++++++++++++++++++++++++++");

    }
    private static void testCase10() {
        // Test Case 10
        System.out.println("\n+++++++++++ Test Case 10: search() Test search by correct code +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        ware.addProduct("TestMake","TestModel",1,Department.ELECTRICAL);
        System.out.println("Code Entered: E0008");
        System.out.println("Product Found: " + ware.search("E0009"));
        System.out.println("+++++++++++++++++++++++++++++ End Test Case 10 +++++++++++++++++++++++++++");

    }
    private static void testCase11() {
        // Test Case 11
        System.out.println("\n+++++++++++ Test Case 11: search() Test search by incorrect code +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        ware.addProduct("TestMake","TestModel",1,Department.ELECTRICAL);
        System.out.println("Code Entered: E0008");
        System.out.println("Product Found: " + ware.search("M0009"));
        System.out.println("+++++++++++++++++++++++++++++ End Test Case 11 +++++++++++++++++++++++++++");

    }
    private static void testCase12() {
        // Test Case 12
        System.out.println("\n+++++++++++ Test Case 12: search() Test search by correct make, model +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        ware.addProduct("TestMake","TestModel",1,Department.ELECTRICAL);
        System.out.println("Make and model Entered: TestMake and TestModel");
        System.out.println("Product Found: " + ware.search("TestMake","TestModel"));
        System.out.println("++++++++++++++++++++++++++++++++++ End Test Case 12 +++++++++++++++++++++++++++++");

    }
    private static void testCase13() {
        // Test Case 13
        System.out.println("\n+++++++++++ Test Case 13: search() Test search by incorrect make, model +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        ware.addProduct("TestMake","TestModel",1,Department.ELECTRICAL);
        System.out.println("Make and model Entered: NotMake and NotModel");
        System.out.println("Product Found: " + ware.search("NotMake","NotModel"));
        System.out.println("+++++++++++++++++++++++++++++ End Test Case 13 +++++++++++++++++++++++++++");

    }
    private static void testCase14() {
        // Test Case 14
        System.out.println("\n+++++++++++ Test Case 14: search() Test search by correct dept +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        ware.addProduct("TestMake","TestModel",1,Department.ELECTRICAL);
        System.out.println("Dept Entered: Electrical");
        System.out.println("Product Found: " + ware.search(Department.ELECTRICAL));
        System.out.println("+++++++++++++++++++++++++++++++ End Test Case 14 +++++++++++++++++++++++++");

    }
    private static void testCase15() {
        // Test Case 15
        System.out.println("\n+++++++++++ Test Case 15: search() Test search by incorrect dept +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        ware.addProduct("TestMake","TestModel",1,Department.ELECTRICAL);
        System.out.println("Dept Entered: null");
        System.out.println("Product Found: " + ware.search((Department) null));
        System.out.println("+++++++++++++++++++++++++++++ End Test Case 15 +++++++++++++++++++++++++++");

    }
    private static void testCase16() {
        // Test Case 16
        System.out.println("\n+++++++++++ Test Case 16: toString() Test toString with products entered +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        ware.addProduct("TestMake","TestModel",1,Department.ELECTRICAL);
        System.out.println(ware);
        System.out.println("+++++++++++++++++++++++++++++++++++ End Test Case 16 +++++++++++++++++++++++++++++++");

    }
    private static void testCase17() {
        // Test Case 17
        System.out.println("\n+++++++++++ Test Case 17: toString() Test toString with no products entered +++++++++++");
        // Test data - Product Instance
        Warehouse ware = new Warehouse("Test Ware");
        System.out.println(ware);
        System.out.println("++++++++++++++++++++++++++++++++++++++ End Test Case 17 +++++++++++++++++++++++++++++++");

    }


}
