package qub.team33.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Adam Thompson (40333846)
 */
class ProductTest {

    String location;
    String newName;
    String name;
    String newDescription;
    String description;
    double newPrice;
    double price;
    int newQuantity;
    int quantity;
    Product product;

    @BeforeEach
    void setUp() {
        location = "A1";
        newName = "New Name";
        name = "Hunky Dorys";
        newDescription = "New Description";
        description = "A Packet of crinkly crisps";
        newPrice = 0.9;
        price = 0.7;
        newQuantity = 15;
        quantity = 8;
        product = new Product(location, name, description, price, quantity);
    }

    @Test
    void getLocation() {
        String expected = location;
        String actual = product.getLocation();

        assertEquals(expected, actual);
    }

    @Test
    void getName() {
        String expected = name;
        String actual = product.getName();

        assertEquals(expected, actual);
    }

    @Test
    void setName() {
        String expected = newName;

        product.setName(expected);
        String actual = product.getName();

        assertEquals(expected, actual);
    }

    @Test
    void getDescription() {
        String expected = description;
        String actual = product.getDescription();

        assertEquals(expected, actual);
    }

    @Test
    void setDescription() {
        String expected = newDescription;

        product.setDescription(expected);
        String actual = product.getDescription();

        assertEquals(expected, actual);
    }

    @Test
    void getPrice() {
        double expected = price;
        double actual = product.getPrice();

        assertEquals(expected, actual);
    }

    @Test
    void setPrice() {
        double expected = newPrice;

        product.setPrice(expected);
        double actual = product.getPrice();

        assertEquals(expected, actual);
    }

    @Test
    void getQuantity() {
        double expected = quantity;
        double actual = product.getQuantity();

        assertEquals(expected, actual);
    }

    @Test
    void setQuantity() {
        int expected = newQuantity;

        product.setQuantity(expected);
        int actual = product.getQuantity();

        assertEquals(expected, actual);
    }

    @Test
    void inStock() {
        product.setQuantity(newQuantity);
        assertTrue(product.inStock());
    }

    @Test
    void purchase() {
        product.setQuantity(newQuantity);
        assertTrue(product.purchase());
    }
}
