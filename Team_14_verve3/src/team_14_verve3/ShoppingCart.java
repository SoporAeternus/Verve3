package team_14_verve3;

import Database.Database;
import java.util.*;
import Products.*;
import javax.swing.JOptionPane;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 *
 */

/*
 * This class contains various methods for managing the Shopping Cart of a Client
 * user
 * 
 * @author Alikhan Amandyk
 * @author Varun Patel
 * @author Di Wang
 * @version 1.0 02/15/2013
 */
public class ShoppingCart {

    public static final int ONE = 1;            // used so hardcoding is avoided and for security reasons
    public static final int ZERO = 0;           // used so hardcoding is avoided and for security reasons
    // first parameter corresponds to productID, 2nd paramater - quantity
    private Vector<Order> shoppingCart;
    private double total_price = 0;
    
    
    // Default Constructor
    public ShoppingCart() 
    {
        shoppingCart = new Vector<Order>();
    }

    /**
     * Add Item to Shopping Cart
     *
     * @param itemID type string- will be the key in the HashTable
     */
    public void addItemToCart(String name,String itemID, String Title,int Quantity,double Price) {
        // adds certain item using itemID
        // PRE: itemID to be correct
        shoppingCart.add(new Order(name,itemID, Title, Quantity,Price));
        total_price += (Price*Quantity);
    }

    public double getTotalPrice()
    {
        return total_price;
    }
    
    /**
     * Delete Item from Shopping Cart
     *
     * @param itemID type string- will be the key in the HashTable.
     */
    public void deleteItemFromCart(String itemID) 
    {
        shoppingCart.remove(itemID);
    }

    /**
     * View Items in the Shopping Cart
     */
    public String viewAllItemsInCart() {
        return "The items in your Shopping Cart: " + shoppingCart.toString();
    }

    /**
     * Quantity of the Items in the cart
     */
    public int cartSize() {
        return shoppingCart.size();
    }

    public int itemNumber()
    {
        int num = 0;
        for(Order o: shoppingCart)
        {
            num += o.getQuantity();
        }
        return num;
    }
    /**
     * Clear the cart
     */
    public void emptyCart() {
        shoppingCart.clear();
    }

    public Order getOrder(int i) {
        // POST: accessor function returns the shopping Cart
        return shoppingCart.get(i);
    }
    
    public void saveToDatabase()
    {
        for(Order o: shoppingCart)
        {
            Database.addOrder(o);
        }
        clear();
    }
    
    public void clear()
    {
        shoppingCart = new Vector<Order>();
        total_price = 0;
    }
}
