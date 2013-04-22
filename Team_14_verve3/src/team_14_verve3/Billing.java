package team_14_verve3;

import java.util.Date;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 *
 */

/*
 * This class contains various methods for managing the Billing Form required for 
 * a user to complete inorder for them to deposit funds into their verve3 accounts.
 * 
 * @author Alikhan Amandyk
 * @author Varun Patel
 * @author Di Wang
 * @version 1.0 02/15/2013
 */
public class Billing {

    private String cardNumber;        // 16-digit card number
    private Date expirationDate;      // month and year is used, day is not used
    private String firstName;         // first name of card holder
    private String lastName;          // last name of card holder
    private String billingAddress;    // billing (street) Address of card holder
    private String billingCity;       // billing city of card holder
    private String billingState;      // billing state of card holder
    private String billingZipCode;    // billing zip code of card holder

    /**
     * Set function acts as Init Constructor to Set Credit Card Number
     *
     * @param cardNumber object of type String that has to be of length 16.
     */
    public void setCardNumber(String cardNumber) {
        // PRE: cardNumber contains 16-digits
        // POST: assigns cardNumber
        if (cardNumber.length() != 16) // simple validation check
        {
            cardNumber = "";
        }
        this.cardNumber = cardNumber;
    }

    /**
     * Set function acts as Init Constructor to Set Expiration Date of Credit
     * Card
     *
     * @param expirationDate object of type Date - needs to be valid date
     */
    public void setExpirationDate(Date expirationDate) {
        // PRE: expirationDate is valid
        // POST: assigns expirationDate
        this.expirationDate = expirationDate;
    }

    /**
     * Set function acts as Init Constructor to Set First Name on Credit Card
     *
     * @param firstName object of type String - needs to be first name on Card
     * not account on verve3
     */
    public void setFirstName(String firstName) {
        // PRE: firstName contains value
        // POST: assigns firstName
        this.firstName = firstName;
    }

    /**
     * Set function acts as Init Constructor to Set Last Name on Credit Card
     *
     * @param lastName object of type String - needs to be last name on Card not
     * account on verve3
     */
    public void setLastName(String lastName) {
        // PRE: lastName contains value
        // POST: assigns firstName
        this.lastName = lastName;
    }

    /**
     * Set function acts as Init Constructor to Set Billing Address on Credit
     * Card
     *
     * @param billingAddress - street address for invoicing/charging on the
     * account with the credit card
     */
    public void setBillingAddress(String billingAddress) {
        // PRE: billingAddress contains value
        // POST: assigns billingAddress
        this.billingAddress = billingAddress;
    }

    /**
     * Set function acts as Init Constructor to Set Billing City of account on
     * Credit Card
     *
     * @param billingCity - billing city for invoicing/charging the account with
     * the credit card
     */
    public void setBillingCity(String billingCity) {
        // PRE: billingCity contains value
        // POST: assigns billingCity
        this.billingCity = billingCity;
    }

    /**
     * Set function acts as Init Constructor to Set Billing State of account on
     * Credit Card
     *
     * @param billingState - billing state for invoicing/charging the account
     * with the credit card
     */
    public void setBillingState(String billingState) {
        // PRE: billingState contains value
        // POST: assigns billingState
        this.billingState = billingState;
    }

    /**
     * Set function acts as Init Constructor to Set Billing ZipCode of account
     * on Credit Card
     *
     * @param billingZipCode - billing zip Code for invoicing/charging the
     * account with the credit card
     */
    public void setBillingZipCode(String billingZipCode) {
        // PRE: billingZipCode contains a valid zipCode, 5-digit or 9-digit
        // POST: assigns billingZipCode
        this.billingZipCode = billingZipCode;
    }

    public String getCardNumber() {
        // POST: returns the cardNumber
        return cardNumber;
    }

    public String getExpirationDate() {
        // POST: returns the expiration Date of the Credit Card
        return expirationDate.getMonth() + "/" + expirationDate.getDate()
                + "/" + expirationDate.getYear();
    }

    public String getFirstName() {
        // POST: returns the first name on Credit Card Billing Account
        return firstName;
    }

    public String getLastName() {
        // POST: returns the last name on Credit Card Billing Account
        return lastName;
    }

    public String getBillingAddress() {
        // POST: returns the street address on the Credit Card Account
        return billingAddress;
    }

    public String getBillingCity() {
        // POST: returns the city for billing purposes on the Credit Card Account
        return billingCity;
    }

    public String getBillingState() {
        // POST: returns the state for billing purposes on the Credit Card Account
        return billingState;
    }

    public String getBillingZipCode() {
        // POST: retursn the zip Code for billing purposes on the Credit Card Account
        return billingZipCode;
    }
}
