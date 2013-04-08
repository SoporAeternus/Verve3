package team_14_verve3;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 *
 */

/*
 * This Class Is the Item List of the items that are sold at verve3
 * 
 * @author Alikhan Amandyk
 * @author Varun Patel
 * @author Di Wang
 * @version 1.0 02/15/2013
 */
public class ItemList {

    public static final int MAX_SIZE = 50;                  // used to set array size of Music,DVD,Book
    public static Music[] musicList = new Music[MAX_SIZE];  // Array of Music at verve3
    public static DVD[] DVDList = new DVD[MAX_SIZE];        // Array of DVDs at verve3
    public static Book[] bookList = new Book[MAX_SIZE];     // Array of Books at verve3
    public static Client[] clientList = new Client[MAX_SIZE];
    public static Manager[] managerList = new Manager[3];
    public static int clientSize = 0;
    public static int chosenClientIndex;
}
