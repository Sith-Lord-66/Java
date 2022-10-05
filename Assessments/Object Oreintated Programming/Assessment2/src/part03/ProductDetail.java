package part03;

import part01.Department;
import part01.Product;

import javax.swing.*;

/**
 * An Object class defining a ProductDetail object that extends the Product class
 *
 * @author James Ross - 40328644
 *
 */
public class ProductDetail extends Product {
    //Declare object attributes
    private String description;
    private ImageIcon image;

    /**
     * Constructor for the ProductDetail object with an int Quantity value
     * @param make a String containing the make of the Product
     * @param model a String containing the model of the Product
     * @param price a double containing the price of the Product
     * @param dept a Department containing the enum for department type
     * @param quantity an int Quantity containing the quantity of a Product
     * @param description the String description of a product
     * @param image the String pathway of an image
     */
    public ProductDetail(String make, String model, double price, Department dept, int quantity, String description, String image) {
        super(make, model, price, dept, quantity);
        this.description = description;
        this.image = new ImageIcon(image);
    }

    /**
     * Constructor for the ProductDetail object
     * @param make a String containing the make of the Product
     * @param model a String containing the model of the Product
     * @param price a double containing the price of the Product
     * @param dept a Department containing the enum for department type
     * @param description the String description of a product
     * @param image the String pathway of an image
     */
    public ProductDetail(String make, String model, double price, Department dept, String description, String image) {
        super(make, model, price, dept);
        this.description = description;
        this.image = new ImageIcon(image);
    }

    /**
     * The getter for the Image
     * @return the ImageIcon Image
     */
    public ImageIcon getImage() {
        return image;
    }

    /**
     * The toString for ProductDetail
     * @return the String containing the details of a ProductDetail
     */
    @Override
    public String toString() {
        String result = super.toString();
        result += ", Description = '" + description + '\'' +
                ",\nImage = ";
        return result;

    }
}
