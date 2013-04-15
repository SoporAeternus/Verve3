package team_14_verve3;

import Database.*;
import Accounts.*;
import Panels.StartPanel;
import java.util.Date;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 *
 */
public class TestDriver{

    public static final int MAX_SIZE = 20; // used for AccountType Vector size
    public static final int SECOND = 1000;
    public static final int TIMER = 10; // 10 second preview

    public static void main(String[] args) throws Exception{
        
        Database.preload();
/*
        // Creating "Pride" and entering credentials. 
        // Store it in the first position of Array musicList
        Database.musicList[0] = new Music();
        Database.musicList[0].setTitle("Pride");
        Database.musicList[0].setArtist("Tiesto ft. U2");
        Database.musicList[0].setFilename("preview1.wav");
        Database.musicList[0].setPrice(1.99);

        // Print out credentials at musicList[0]
        System.out.println("ProductID for Song- (" + Database.musicList[0].getTitle()
                + "  by " + Database.musicList[0].getArtist() + ") : "
                + Database.musicList[0].getProductID());

        // Create a new test Client- Test the default Constructor and Setters
        Client testClient = new Client();
        testClient.setName("Erich Stoekl");
        testClient.setUserName(new UserNameValidation("i_love_programming"));
        testClient.setAddress("IST 220, State College 16802");
        testClient.setDOB(new Date(1990, 04, 25));
        // deposit funds into the account of Erich
        testClient.depositFunds(25.30);


        // Add items to the shopping cart of test Client
        testClient.getShoppingCart().addItemToCart(Database.musicList[0].getProductID());
        // Print you the shopping cart [should have one item]
        System.out.println(testClient.getShoppingCart().viewAllItemsInCart());

        System.out.println();
        System.out.println();

        // Add another item to the shopping cart of test Client
        testClient.getShoppingCart().addItemToCart(Database.musicList[0].getProductID());
        // Print out the shopping cart- should have two items. One item, with quantity of 2
        System.out.println(testClient.getShoppingCart().viewAllItemsInCart());

        // Play the preview of the song. The preview is available if not bought
        /**
         * ********* Un-Comment this selection to listen to the
         * preview**************** ********* Un-Comment this selection to listen
         * to the preview**************** ********* Un-Comment this selection to
         * listen to the preview****************
         * Database.musicList[0].preview(); try { Thread.sleep(SECOND * TIMER);
         * } catch (InterruptedException ex) {
         * Thread.currentThread().interrupt(); }
         * Database.musicList[0].stopPreview();
         *
        // ******************************************************************************
        // Clear Shopping Cart if you have enough funds - testing the transaction method
        testClient.transaction();
        // get the new Balance of testClient - should be $21.32
        System.out.printf("New Balance: %5.2f of Client: %s \n ", testClient.getBalance(), testClient.getName());

        System.out.println();
        // The shopping cart should be empty since all the items were purchased successfully.
        System.out.println(testClient.getShoppingCart().viewAllItemsInCart());

        // Creating "Never Say Never" and entering credentials. 
        // Store it in the second position of Array musicList
        Database.musicList[1] = new Music();
        Database.musicList[1].setTitle("Never Say Never");
        Database.musicList[1].setArtist("Arminn van Buuren feat. Jacqueline Govaert");
        Database.musicList[1].setPrice(0.99);

        System.out.println();

        // Print out credentials at musicList[1]
        System.out.println("ProductID for Song- (" + Database.musicList[1].getTitle()
                + "  by " + Database.musicList[1].getArtist() + ") : "
                + Database.musicList[1].getProductID());

        // Creating "Angel Monster" and entering credentials. 
        // Store it in the third position of Array musicList
        Database.musicList[2] = new Music();
        Database.musicList[2].setTitle("Angel Monster");
        Database.musicList[2].setArtist("Buckethead");
        Database.musicList[2].setPrice(1.29);

        System.out.println();
        System.out.println();
        // Print out credentials at musicList[2]
        System.out.println("ProductID for Song- (" + Database.musicList[2].getTitle()
                + "  by " + Database.musicList[2].getArtist() + ") : "
                + Database.musicList[2].getProductID());

        // Add items to the shopping cart of test Client
        testClient.getShoppingCart().addItemToCart(Database.musicList[1].getProductID());
        testClient.getShoppingCart().addItemToCart(Database.musicList[1].getProductID());
        testClient.getShoppingCart().addItemToCart(Database.musicList[2].getProductID());
        // Print the shopping cart [should have one item]
        System.out.println(testClient.getShoppingCart().viewAllItemsInCart());

        // Creating "Soul Surfer" and entering credentials. 
        // Store it in the first position of Array DVDList        
        Database.DVDList[0] = new DVD();
        Database.DVDList[0].setTitle("Soul Surfer");
        Database.DVDList[0].setDirector("Sean McNamara");
        Database.DVDList[0].setPrice(4.29);

        System.out.println();
        System.out.println();
        // Print out credentials at DVDList[0]
        System.out.println("ProductID for Movie- (" + Database.DVDList[0].getTitle()
                + "  by " + Database.DVDList[0].getDirector() + ") : "
                + Database.DVDList[0].getProductID());

        // Add items to the shopping cart of test Client
        testClient.getShoppingCart().addItemToCart(Database.DVDList[0].getProductID());
        // Print the shopping cart [Should have two songs of same kind, another song
        // and one Movie[DVD] - confirm with the ID numbers
        System.out.println(testClient.getShoppingCart().viewAllItemsInCart());
        System.out.println();
        // Purchase whatever was added onto the shopping cart
        testClient.transaction();

        // Display the results- new balance should be $13.76 of Client Erich Stoekl
        System.out.printf("New Balance(in dollars): %5.2f of Client %s \n ", testClient.getBalance(), testClient.getName());

        System.out.println();
        // should be no items in the Shopping Cart.
        System.out.println(testClient.getShoppingCart().viewAllItemsInCart());
        System.out.println();

        // Creating "Lord of the Rings" and entering credentials. 
        // Store it in the first position of Array bookList        
        Database.bookList[0] = new Book();
        Database.bookList[0].setTitle("Lord of the Rings");
        Database.bookList[0].setAuthor("J. R. R. Tolkien");
        Database.bookList[0].setPrice(14.29);

        // Add items to the shopping cart of test Client - Adding a Book
        testClient.getShoppingCart().addItemToCart(Database.bookList[0].getProductID());

        // Shopping Cart should have one Book
        System.out.println(testClient.getShoppingCart().viewAllItemsInCart());
        System.out.println();
        // Purchase whatever was added onto the shopping cart - Should Fail
        testClient.transaction();

        // Display the results- new balance should be $13.76 of Client Erich Stoekl
        System.out.printf("New Balance(in dollars): %5.2f of Client %s \n ", testClient.getBalance(), testClient.getName());

        System.out.println();
        System.out.println();
        System.out.println();

        // All Test Success
        Manager testManager = new Manager();
        testManager.AddContent("helloJello", "Test title");
        for (int i = 0; i < Database.musicList.length; i++) {
            if (Database.musicList[i] == null) {
                break;
            } else {
                System.out.println(Database.musicList[i].getTitle());
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();

        testManager.AddContent("Music", "Aruzhan");
        for (int i = 0; i < Database.musicList.length; i++) {
            if (Database.musicList[i] == null) {
                break;
            } else {
                System.out.println(Database.musicList[i].getTitle());
            }
        }

        testManager.retrieveCustomerInformation("ThisIsATest");*/

        StartPanel.main(args);
    }
}
