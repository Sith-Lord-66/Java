package part03;

import part01.Department;
import part01.Product;
import part01.Warehouse;

import java.util.ArrayList;

/**
 * An Object class defining a WarehouseDetail object that extends the Warehouse class
 *
 * @author James Ross - 40328644
 *
 */
public class WarehouseDetail extends Warehouse {

    /**
     * The constructor for the WarehouseDetail object
     * @param name the String name of the warehouseDetail
     */
    public WarehouseDetail(String name) {
        super(name);
    }

    /**
     * This method adds a ProductDetail to the main Warehouse Class
     * @param make the string containing the make of a product
     * @param model the string containing the make of a product
     * @param price the double containing the price of a product
     * @param dept the Department containing the department of a product
     * @param desc the string containing the description of a product
     * @param image the string containing the pathway of an Image of a product
     * @return a String OK if successfully added, if not a string error
     */
    public String addProduct(String make, String model, double price, Department dept, String desc, String image) {
        //executes if the make and model are not already present
        if (super.checkMakeModel(make,model)) {
            //Creates a new ProductDetail
            ProductDetail product = new ProductDetail(make, model, price, dept, desc, image);
            //Calls a method to add the ProductDetail to the warehouse class' data ArrayList
            addProductDetail(product);
            return "OK";
        } else return "Error: This item already exists";
    }

    /**
     * This method adds a ProductDetail to the main Warehouse Class
     * @param make the string containing the make of a product
     * @param model the string containing the make of a product
     * @param price the double containing the price of a product
     * @param dept the Department containing the department of a product
     * @param qty the int quantity containing the quantity of a product
     * @param desc the string containing the description of a product
     * @param image the string containing the pathway of an Image of a product
     * @return a String OK if successfully added, if not a string error
     */
    public String addProduct(String make, String model, double price, Department dept, int qty, String desc, String image) {
        //executes if the make and model are not already present
        if (super.checkMakeModel(make,model)) {
            //Creates a new ProductDetail
            ProductDetail product = new ProductDetail(make, model, price, dept, qty, desc, image);
            //Calls a method to add the ProductDetail to the warehouse class' data ArrayList
            addProductDetail(product);
            return "OK";
        } else return "Error: This item already exists";
    }

    /**
     * This method calls a method to sort products by department
     * @param dept the Department to be sorted by
     * @return the sorted Arraylist of Products
     */
    public ArrayList<Product> sortedProds(Department dept){
        return super.search(dept);
    }

}
