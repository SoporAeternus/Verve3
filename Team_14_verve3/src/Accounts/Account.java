package Accounts;

import java.util.Date;
import team_14_verve3.UserNameValidation;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 */

/*
 * This class contains various methods for managing the Account Type of a user
 * registered at the verve3
 * Abstract Class that will be extended by Client Account type and Manager Account type
 * 
 * @author Alikhan Amandyk
 * @author Varun Patel
 * @author Di Wang
 * @version 1.0 02/15/2013
 */
public abstract class Account {
    // this class is going to be inherited by Client and Manager classes

    protected String name;           // name of account holder
    protected String address;        // account holder's address
    protected Date DOB;              // format YYYY, MM, DD // date of birth
    protected String username;       // username- going to be checked by UserNamevalidation Class
    protected String password;       // password - user pass string
    protected String accountID;      // Account ID - randomly generated number [8 digit]
    protected UserNameValidation userName;  // necessary to check if username is correct
    public static boolean correctEmail = true;  // check if the email is true
    private String ACCOUNT_TYPE;
    // default constructor
    public Account() {
        // default constructor, all fields are set to blank
        name = "";
        address = "";
        DOB = new Date(90, 1, 1);               // standard date of birth
        userName = new UserNameValidation();
        accountID = generateAccountID();
        while (doesAccountIDExist(accountID)) // need to check if such ID already exists
        {
            accountID = generateAccountID();    // if not valid, generates ID again
        }
        password = "";
    }
    public Account(String[] user)
    {
        this.setAccountType(user[0]);
        this.setUserName(new UserNameValidation(user[1])); 
        this.setPassword(user[2]);
        this.setName(user[3]);
        this.setAddress(user[4]);
        int Y = Integer.parseInt(user[5]);
        int M = Integer.parseInt(user[6]);
        int D = Integer.parseInt(user[7]);
        this.setDOB(new Date(Y,M,D));
        
    }
    public void setAccountType(String accountType)
    {
        this.ACCOUNT_TYPE = accountType;
    }
    
    /**
     * Set function acts as Init Constructor to Set userName
     *
     * @param userName the object of type UserNameValidation to be checked if
     * valid. then assigned to this.userName
     */
    public void setUserName(UserNameValidation userName) {
        // PRE: userName initialized
        // POST: validates userName first, then assigns to this.userName
        //       if not correct, prints error message
        if (userName.isValid()) {
            this.username = userName.getUserName();
        } else {
            System.out.println("Invalid username entered:  (" + userName + ") . Please Choose another UserName: ");
        }
    }

    /**
     * Set function acts as Init Constructor to Set Name on account
     *
     * @param name type string that set's name of user on account
     */
    public void setName(String name) {
        // PRE: name contains value
        // POST: assigns name
        this.name = name;
    }

    public void setPassword(String password) {
        if ((password.length() >= 1) || (password.length() <= 64)){
        this.password = password;
        } else {
            System.out.println("Password Length Out of Bounds");
            return;
        }
    }

    /**
     * Set function acts as Init Constructor to Set Address on user account
     *
     * @param address type string that set's address of user on account
     */
    public void setAddress(String address) {
        // PRE: address contains value
        // POST: assigns address
        this.address = address;
    }

    /**
     * Set function acts as Init Constructor to Set DOB on user account
     *
     * @param DOB DOB object of type Date Class that set's the date of Birth of
     * user on account
     */
    public void setDOB(Date DOB) {
        // PRE: DOB contains correct date
        // POST: assigns DOB
        DOB.setYear(DOB.getYear() - 1900);
        this.DOB = DOB;
    }

    /**
     * Private method used to generate the Account ID of a Client
     *
     * Acts as an init constructor- sets ID to randomly generated ID
     */
    private String generateAccountID() {
        // randomly generates 6-digit number for ID
        // the algorithm is taken from Lab2, Box-Muller transform
        double u1 = Math.random(); // first, generating uniformly-distributed random numbers
        double r = Math.sqrt(-2 * Math.log(u1));

        int ID = (int) (r * 10000000) + 10000000;
        return accountID = "" + ID;
    }

    /**
     * Check to see if an account ID already exists [error catching incase a
     * duplicate account ID is produced by the random account ID generator
     *
     * @param accountID random 8 digit account number of type string consisting
     * of numbers
     */
    private boolean doesAccountIDExist(String accountID) {
        return false; // for now - will be changed when SQL unit is covered and
        // there is a list of accountID's to check  from.
        /**
         * if (this.accountID.equals(accountID)) { return true; } else { return
         * false; }
         */
    }

    /**
     * Abstract Panel- redundant at phase 1. Will be implemented with Phase #2
     * Client and Manager will have different panels.
     */
    public abstract void panel();
    // client panel, GUI skills needed

    /**
     * Get Name Accessor
     *
     * returns the 'read-only' copy of private protected Data Member name.
     */
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return username;
    }
    
    public String getAccountType()
    {
        return ACCOUNT_TYPE;
    }
    
    public String getAddress()
    {
        return this.address;
    }
    
    /**
     * toString method that returns the Credentials of the User Account
     */
    @Override
    public String toString() {
        // POST: prints info about current object
        return "Account Type: " + this.getClass().getSimpleName() + "\n"
                + "Name: " + name + "\n"
                + "Address: " + address + "\n"
                + "DOB: " + DOB.getMonth() + "/" + DOB.getDate() + "/" + DOB.getYear() + "\n"
                + "UserName: " + userName + "\n"
                + "Account ID: " + accountID + "\n";
    }
}
