package Products;

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

    protected String PRODUCT_ID;           // used for search, 6-digit
    protected String TITLE;               // name of an Item
    protected String GENRE;               // genre of Item
    protected double PRICE;               // price of Item
    protected double RATING;              // rating of Item
    protected int QUANTITY_SOLD;           // Quantity Sold of Item
    protected Date PUBLISH_DATE;         // Publish Date of Item

    // default constructor
    public Item() {
        PRODUCT_ID = generateID();             // randomly generated
        while (!isProductID_valid(PRODUCT_ID)) // need to check if such ID already exists
        {
            PRODUCT_ID = generateID();         // if not valid, generates ID again
        }
        TITLE = "";
        GENRE = "";
        PRICE = 0.0;
        RATING = 0.0;
        QUANTITY_SOLD = 0;
        PUBLISH_DATE = new Date(113, 1, 1);    // default date, that is 1/1/2013
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
    
    public void setRating(double newRating)
    {
        this.RATING = newRating;
    }
    
    public void setPID(String pid)
    {
        PRODUCT_ID = pid;
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
        this.TITLE = title;
    }

    /**
     * Set function acts as Init Constructor to Set Genre of Item
     *
     * @param genre type string that set's genre of a product
     */
    public void setGenre(String genre) {
        // PRE: genre contains value
        // POST: assigns genre
        this.GENRE = genre;
    }

    /**
     * Set function acts as Init Constructor to Set Price of Item
     *
     * @param price type double that set's price of a product
     */
    public void setPrice(double price) {
        // PRE: price >= 0
        // POST: assigns price
        this.PRICE = price;
    }

    /**
     * Set function acts as Init Constructor to Set publish Date of Item
     *
     * @param publishDate type Date Class that set's publish Date of a product
     */
    public void setPublishDate(Date publishDate) {
        // PRE: publishDate is valid
        // POST: assigns publishDate
        this.PUBLISH_DATE.setYear(publishDate.getYear() - 1900);
        this.PUBLISH_DATE.setMonth(publishDate.getMonth());
        this.PUBLISH_DATE.setDate(publishDate.getDate());
    }

    public void resetRating(double newRating) 
    {
        // POST: reset the rating of an Item to 0
        RATING =newRating;
    }

    public String getTitle() {
        // POST: returns title of Item
        return TITLE;
    }

    public String getProductID() {
        // POST: returns productID of Item
        return PRODUCT_ID;
    }

    public String getGenre() {
        // POST: returns genre of Item
        return GENRE;
    }

    public double getPrice() {
        // POST: returns price of Item
        return PRICE;
    }

    public double getRating() {
        // POST: returns rating of Item
        return RATING;
    }

    public int getQuantitySold() {
        // POST: returns quantity sold of Item
        return QUANTITY_SOLD;
    }

    public void incrementRanking(int num) {
        // POST: function called that increments by one when one more quantity is sold
        QUANTITY_SOLD += num;
    }

    public String getDate() {
        // POST: returns the publish date of Item
        return "Publish Date: " + PUBLISH_DATE.getMonth() + "/" + PUBLISH_DATE.getDate() + "/" + PUBLISH_DATE.getYear() + "\n";
    }
}
