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
    protected UserNameValidation userName;  // necessary to check if username is correct
    private String ACCOUNT_TYPE;
    // default constructor
    public Account() {
        // default constructor, all fields are set to blank
        name = "";
        address = "";
        DOB = new Date(90, 1, 1);               // standard date of birth
        userName = new UserNameValidation();
        password = "";
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
    public void setUserName(String userName) {
        // PRE: userName initialized
        // POST: validates userName first, then assigns to this.userName
        //       if not correct, prints error message
        this.username = userName;
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
                + "UserName: " + userName + "\n";
    }
}
