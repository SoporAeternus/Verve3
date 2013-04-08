package team_14_verve3;

import java.util.Date;
import java.lang.Math;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 *
 */

/*
 * This abstract class contains various methods for managing the Items class.
 * This class will be extended by the Books Class, DVD Class, and Music Class
 * 
 * @author Alikhan Amandyk
 * @author Varun Patel
 * @author Di Wang
 * @version 1.0 02/15/2013
 */
public abstract class Item {

    protected String productID;           // used for search, 6-digit
    protected String title;               // name of an Item
    protected String genre;               // genre of Item
    protected double price;               // price of Item
    protected double rating;              // rating of Item
    protected int quantitySold;           // Quantity Sold of Item
    protected Date publishDate;           // Publish Date of Item

    // default constructor
    public Item() {
        productID = generateID();             // randomly generated
        while (!isProductID_valid(productID)) // need to check if such ID already exists
        {
            productID = generateID();         // if not valid, generates ID again
        }
        title = "";
        genre = "";
        price = 0.0;
        rating = 0.0;
        quantitySold = 0;
        publishDate = new Date(113, 1, 1);    // default date, that is 1/1/2013
    }

    /**
     * Private method used to generate the Product ID of an Item
     *
     */
    public static String generateID() {
        // randomly generates 6-digit number for ID
        // the algorithm is taken from Lab2, Box-Muller transform
        double u1 = Math.random();	// first, generating uniformly-distributed random numbers
        double r = Math.sqrt(-2 * Math.log(u1));

        int ID = (int) (r * 100000);
        return "" + ID;
    }

    /**
     * Check to see if an product ID already exists [error catching incase a
     * duplicate product ID is produced by the random product ID generator
     *
     * @param productID random 6 digit product number of type string consisting
     * of numbers
     */
    private boolean isProductID_valid(String productID) {
        return true;   // for now - will be changed when SQL unit is covered and
        // there is a list of accountID's to check  from.
        /**
         * // supposed to check if productID already exists in items list // if
         * does exist, returns false // otherwise, returns true if
         * (this.productID.equals(productID)){ return false; } else { return
         * true; }
         */
    }

    /**
     * Set function acts as Init Constructor to Set Title of Item
     *
     * @param title type string that set's title of a product
     */
    public void setTitle(String title) {
        // PRE: title contains value
        // POST: assigns title
        this.title = title;
    }

    /**
     * Set function acts as Init Constructor to Set Genre of Item
     *
     * @param genre type string that set's genre of a product
     */
    public void setGenre(String genre) {
        // PRE: genre contains value
        // POST: assigns genre
        this.genre = genre;
    }

    /**
     * Set function acts as Init Constructor to Set Price of Item
     *
     * @param price type double that set's price of a product
     */
    public void setPrice(double price) {
        // PRE: price >= 0
        // POST: assigns price
        this.price = price;
    }

    /**
     * Set function acts as Init Constructor to Set publish Date of Item
     *
     * @param publishDate type Date Class that set's publish Date of a product
     */
    public void setPublishDate(Date publishDate) {
        // PRE: publishDate is valid
        // POST: assigns publishDate
        this.publishDate.setYear(publishDate.getYear() - 1900);
        this.publishDate.setMonth(publishDate.getMonth());
        this.publishDate.setDate(publishDate.getDate());
    }

    public void resetRating() {
        // POST: reset the rating of an Item to 0
        rating = 0;
    }

    public String getTitle() {
        // POST: returns title of Item
        return title;
    }

    public String getProductID() {
        // POST: returns productID of Item
        return productID;
    }

    public String getGenre() {
        // POST: returns genre of Item
        return genre;
    }

    public double getPrice() {
        // POST: returns price of Item
        return price;
    }

    public double getRating() {
        // POST: returns rating of Item
        return rating;
    }

    public int getQuantitySold() {
        // POST: returns quantity sold of Item
        return quantitySold;
    }

    public void incrementRanking() {
        // POST: function called that increments by one when one more quantity is sold
        quantitySold++;
    }

    public String getDate() {
        // POST: returns the publish date of Item
        return "Publish Date: " + publishDate.getMonth() + "/" + publishDate.getDate() + "/" + publishDate.getYear() + "\n";
    }
}
