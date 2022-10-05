package part01;

import java.util.ArrayList;

/**
 * An Object class defining a Warehouse object
 *
 * @author James Ross - 40328644
 *
 */
public class Warehouse implements iWare{

    //Defining attributes for the warehouse object
    private ArrayList<Product> data = new ArrayList<>();
    private String name;

    /**
     * The constructor for the warehouse object
     * @param name the String name for the warehouse
     */
    public Warehouse(String name){
        this.name = name;
    }

    /**
     * The getter for the name of the warehouse
     * @return the String name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * This method adds all the Products in an ArrayList to an array of Products
     * @return the Product[] array
     */
    @Override
    public Product[] getAllProducts() {
        //this executes if there are any products
        if(data.size()>0){
            //Creates an array of products
            Product[] products = new Product[data.size()];
            //Executes for each product in the arrayList
            for(int index=0; index<data.size(); index++){
                //adds the product to an array
               products[index] = data.get(index);
           }
            return products;
        }else return null;
    }

    /**
     * This method adds a Product to the ArrayList data
     * @param make the String containing make of product
     * @param model the String containing model of product
     * @param price the double containing price of product
     * @param dept the Department containing department of product
     * @return A string OK if successfully added, if not a String error
     */
    @Override
    public String addProduct(String make, String model, double price, Department dept) {
        //checks the make and model are not already in the warehouse
        if (checkMakeModel(make,model)) {
            //Creates a new Product
            Product product = new Product(make, model, price, dept);
            //adds the product to the ArrayList data
            data.add(product);
            return "OK";
            //Returns an error if the make and model are present in warehouse
        } else return "Error: This item already exists";

    }

    /**
     * This method adds a Product to the ArrayList data
     * @param make the String containing make of product
     * @param model the String containing model of product
     * @param price the double containing price of product
     * @param dept the Department containing department of product
     * @param qty the int qty containing the quantity of a product
     * @return A string OK if successfully added, if not a String error
     */
    @Override
    public String addProduct(String make, String model, double price, Department dept, int qty) {
        //checks the make and model are not already in the warehouse
        if (checkMakeModel(make,model)) {
            //Creates a new Product
            Product product = new Product(make, model, price, dept, qty);
            //adds the product to the ArrayList data
            data.add(product);
            return "OK";
            //Returns an error if the make and model are present in warehouse
        } else return "Error: This item already exists";
    }

    /**
     *This method deletes an specified product from the Arraylist data
     * @param pCode the String code used to identify the product
     * @return a true or false value depending on if the product is succesfully deleted
     */
    @Override
    public boolean deleteProduct(String pCode) {
        //executes for each product in the Arraylist data
        for(Product prod: data){
            //executes if the pCode is the same as the product Code
            if (prod.getCode().equals(pCode)){
                //removes the product for data
                data.remove(prod);
                return true;
            }
            //returns false if product codes do not match
        }return false;
    }

    /**
     * This method increases the quantity of a product by a specified amount
     * @param pCode the String code of the product
     * @param quantity the int amount to be added
     * @return a true or false value depending on if the quantity has been sucessfully added
     */
    @Override
    public boolean restock(String pCode, int quantity) {
        if(quantity>0) {
            //executes for each product in ArrayList data
            for (Product prod : data) {
                //executes if pCode matches the product code
                if (prod.getCode().equals(pCode)) {
                    //adds the amount to the product quantity
                    prod.addToQuantity(quantity);
                    return true;
                }
            }
        }
        //return false if the quantity has not been updated
        return false;
    }

    /**
     * Searches the Arraylist data for a product with a code matching a specified one
     * @param code the String code to be searched for
     * @return the Product if it is found, if not it will return null
     */
    @Override
    public Product search(String code) {
        //executes for each product in Arraylist data
        for (Product prod: data){
            //executes if code is equal to the product Code
            if (prod.getCode().equals(code)){
                //returns the product
                return prod;
            }
        }
        return null;
    }

    /**
     * Searches the Arraylist data for a product with a make and model matching a specified one
     * @param make the String make to be searched for
     * @param model the String mdeol to be searched for
     * @return the Product if it is found, if not it will return null
     */
    @Override
    public Product search(String make, String model) {
        //executes for each product in Arraylist data
        for (Product prod: data){
            //executes if the make and model is equal to the product make and model
            if (prod.getMake().equals(make) && prod.getModel().equals(model)){
                //returns the product
                return prod;
            }
        }
        return null;
    }

    /**
     * Searches the Arraylist data for products within a certain department
     * @param dept the Department to be searched for
     * @return an Arraylist of Products if found, if not it will return null
     */
    @Override
    public ArrayList<Product> search(Department dept) {
        //creates an ArrayList
        ArrayList<Product> departmentProducts = new ArrayList<>();
        //executes for each product in Arraylist data
        for (Product prod: data){
            //executes if the department is equal to product department
            if (prod.getDepartment().equals(dept)){
                //adds product to the ArrayList departmentProducts
                departmentProducts.add(prod);
            }
        }
        return departmentProducts;
    }

    /**
     * The toString for warehouse
     * @return a String containing all products in the warehouse sorted by department
     */
    @Override
    public String toString()  {
        if(data.size() == 0){
            return "\nNo Products in Warehouse";
        }
        //Creates a string and adds name to it
        String result = "\nWarehouse Name: " + name;

        //Calls a method that adds all products in a certain department to a string
        result = depts(Department.ELECTRICAL,result);
        result = depts(Department.PHOTOGRAPHIC,result);
        result = depts(Department.COMPUTING,result);
        result = depts(Department.BOOKS,result);
        result = depts(Department.MUSIC,result);
        result = depts(Department.FASHION,result);
        result = depts(Department.OTHER,result);
        return result;
    }

    /**
     * This method adds all products in a department to a string
     * @param dept the specified department
     * @param result the String containing Products
     * @return the String containing products
     */
    private String depts(Department dept, String result){
        //adds the name of the department to the string
        result += "\n\n" + dept;
        //Calls a method that searches for products by dept
        ArrayList<Product> sorted  = search(dept);
        //executes for each product in sorted
        for(Product prod: sorted){
            //adds product to String
            result += "\n" + prod;
        }
        return result;
    }

    /**
     * Protected method for use by the WarehouseDetail class in part 3
     * It adds a ProductDetail to the ArrayList data
     * @param productDetail the ProductDetail to be added
     */
    protected void addProductDetail(Product productDetail){
        data.add(productDetail);
    }

    /**
     * Protected method used in WarehouseDetail in part 3 and Warehouse
     * This method checks if a product with a make or model is present in data
     * @param make the String make of a Product
     * @param model the String model of a Product
     * @return a true or false value if a product is found
     */
    protected boolean checkMakeModel(String make, String model){
        //executes for each product in data
        for (Product prod : data) {
            //executes if a product with the same make and model is found
            if (prod.getMake().equals(make) && prod.getModel().equals(model)) {
                return false;

            }
        }
        return true;
    }

}
