package team_14_verve3;

import java.util.Enumeration;
import java.util.TreeSet;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 *
 */

/*
 * This class contains various methods for managing the Client user at verve 3
 * This class extends AccountType Class
 * 
 * @author Alikhan Amandyk
 * @author Varun Patel
 * @author Di Wang
 * @version 1.0 02/15/2013
 */
public class Client extends AccountType {

    private double balance;                  // balance which allows to purchase items
    private ShoppingCart clientCart;         // client's shopping cart
    private Billing billingInfo;             // client's billing info
    private Enumeration<String> ID_list;     // list of productIDs in clientCart
    private TreeSet<String> boughtList;      // list of already purchased items

    // default constructor    
    public Client() {
        super();
        clientCart = new ShoppingCart();
        billingInfo = new Billing();
        boughtList = new TreeSet<String>();
        balance = 0.0;
        ID_list = null;
    }

    // will be implemented in the GUI phase
    @Override
    public void panel() {
        // Client has own panel
        // to be implemented using GUI
    }

    public double getBalance() {
        // POST: returns the balance on the account
        return balance;
    }

    public ShoppingCart getShoppingCart() {
        // POST: returns the items in the Shopping cart that the user has added on
        return this.clientCart;
    }

    public Billing getBillingInfo() {
        // POST: returns the billing info of the Client
        return this.billingInfo;
    }

    /**
     * Deposit Funds into the Client Account
     *
     * @param balance type double that adds funds to existing balance (in
     * dollars currency)
     */
    public void depositFunds(double balance) {
        if (balance > 0) {
            this.balance += balance;
        } else {
            // do Nothing
        }
    }

    /**
     * Transaction Function takes items in the shopping cart and checks them out
     * if there are enough funds available. if not, the transaction fails and
     * the shopping cart remains as is. The existin Balance also will not change
     * if there aren't enough funds to purchase the item.
     *
     */
    public void transaction() {
        ID_list = clientCart.getShoppingCart().keys();
        // getting list of productID that client is going to purchase

        while (ID_list.hasMoreElements()) {
            String anID = ID_list.nextElement();
            // anID will be searched in ItemList arrays
            int aQuantity = clientCart.getShoppingCart().get(anID);
            // quantity stored;
            boolean isFound = false;
            while (!isFound) // looking for object with such anID
            // in all arrays
            {
                for (Music m : ItemList.musicList) {
                    if (m == null) // if there are no more items
                    {
                        break;
                    }
                    if (m.getProductID().equals(anID)) // if found such productID
                    {
                        boughtList.add(anID);
                        double price = m.getPrice();
                        // get price
                        double total = price * aQuantity;
                        // calculate subtotal
                        if (total <= balance) {
                            balance -= total;
                            m.incrementRanking();
                            clientCart.deleteItemFromCart(anID);
                        }
                        // substract from balance
                        isFound = true;
                    }
                }
                // loop through Book
                for (Book m : ItemList.bookList) {
                    if (m == null) {
                        break;
                    }
                    if (m.getProductID().equals(anID)) {
                        boughtList.add(anID);
                        double price = m.getPrice();
                        double total = price * aQuantity;
                        if (total <= balance) {
                            balance -= total;
                            m.incrementRanking();
                            clientCart.deleteItemFromCart(anID);
                        }
                        isFound = true;
                    }
                }
                // loop through DVDs
                for (DVD m : ItemList.DVDList) {
                    if (m == null) {
                        break;
                    }
                    if (m.getProductID().equals(anID)) {
                        boughtList.add(anID);
                        double price = m.getPrice();
                        double total = price * aQuantity;
                        if (total <= balance) {
                            balance -= total;
                            m.incrementRanking();
                            clientCart.deleteItemFromCart(anID);
                        }
                        isFound = true;
                    }
                }
            }
        }
    }
}
