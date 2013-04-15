package Accounts;
import team_14_verve3.*;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 *
 */

/*
 * This class contains various methods for managing the Client user at verve 3
 * This class extends Account Class
 * 
 * @author Alikhan Amandyk
 * @author Varun Patel
 * @author Di Wang
 * @version 1.0 02/15/2013
 */
public class Client extends Account 
{

    private double BALANCE;                   // balance which allows to purchase items
    private Billing MY_BILLING;              // client's billing info
    
    // default constructor    
    public Client() {
        super();
        BALANCE = 0.0;
    }
    
    public Client(String[] user)
    {
        super(user);
        BALANCE = Double.parseDouble(user[8]);
    }

    public Double getBalance()
    {
        return BALANCE;
    }
    // will be implemented in the GUI phase
    @Override
    public void panel() {
        // Client has own panel
        // to be implemented using GUI
    }
/*
    public ShoppingCart getShoppingCart() {
        // POST: returns the items in the Shopping cart that the user has added on
        return this.clientCart;
    }

    public Billing getBillingInfo() {
        // POST: returns the billing info of the Client
        return this.billingInfo;
    }
*/
    /**
     * Deposit Funds into the Client Account
     *
     * @param balance type double that adds funds to existing balance (in
     * dollars currency)
     */
    public void depositFunds(double balance) {
        if (balance > 0) {
            this.BALANCE += balance;
        } else {
            // do Nothing
        }
    }
    
    public void buy(double balance)
    {
        BALANCE -= balance;
    }

    /*
     * Transaction Function takes items in the shopping cart and checks them out
     * if there are enough funds available. if not, the transaction fails and
     * the shopping cart remains as is. The existin Balance also will not change
     * if there aren't enough funds to purchase the item.
     *
    */
}
