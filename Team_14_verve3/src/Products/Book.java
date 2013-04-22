package Products;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 *
 */

/*
 * This class contains various methods for managing the Book Items sold by verve3
 * this class is the extenstion of abstract class Item
 * 
 * @author Alikhan Amandyk
 * @author Varun Patel
 * @author Di Wang
 * @version 1.0 02/15/2013
 */
public class Book extends Item {

    private String AUTHOR;       // book author

    // default constructor
    public Book() {
        super();
        AUTHOR = "";
    }
    
    public Book(String[] newBook)
    {
        super();
    }
    
    /**
     * Set function acts as Init Constructor to Set Author of Book
     *
     * @param author type string- assigned to private data member author
     */
    public void setAuthor(String author) {
        this.AUTHOR = author;
    }

    /**
     * Accessor to get private data member "author" of Book Class
     *
     */
    public String getAuthor() {
        return AUTHOR;
    }
}
