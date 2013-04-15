package team_14_verve3;

import java.util.*;
import Products.*;

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
    private Hashtable<String, Integer> shoppingCart;
    
    // Default Constructor
    public ShoppingCart() {
        shoppingCart = new Hashtable<String, Integer>();
    }

    /**
     * Add Item to Shopping Cart
     *
     * @param itemID type string- will be the key in the HashTable
     */
    public void addItemToCart(String itemID,int Quantity) {
        // adds certain item using itemID
        // PRE: itemID to be correct
        shoppingCart.put(itemID, Quantity);
    }

    /**
     * Retrieve item from shopping Cart using the Key (will output quantity)
     *
     * @param itemID type string- will be the key in the HashTable
     */
    public int getItem(String itemID) {
        if (shoppingCart.containsKey(itemID)) {
            return shoppingCart.get(itemID);
        } else {
            return ZERO;
        }
    }

    /**
     * Delete Item from Shopping Cart
     *
     * @param itemID type string- will be the key in the HashTable.
     */
    public void deleteItemFromCart(String itemID) {
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

    /**
     * Clear the cart
     */
    public void emptyCart() {
        shoppingCart.clear();
    }

    public Hashtable<String, Integer> getShoppingCart() {
        // POST: accessor function returns the shopping Cart
        return shoppingCart;
    }
}
