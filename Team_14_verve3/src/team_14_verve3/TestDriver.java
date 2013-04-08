package team_14_verve3;

import Panels.StartPanel;
import java.util.Date;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 *
 */
public class TestDriver {

    public static final int MAX_SIZE = 20; // used for AccountType Vector size
    public static final int SECOND = 1000;
    public static final int TIMER = 10; // 10 second preview

    public static void main(String[] args) {

        // Credentials for Manager #1 -Test all the manager setters
        ItemList.managerList[0] = new Manager();
        ItemList.managerList[0].setName("Varun Patel");
        ItemList.managerList[0].setUserName(new UserNameValidation("rainmaker490"));
        ItemList.managerList[0].setAddress("446 State College 16803");
        ItemList.managerList[0].setDOB(new Date(1990, 4, 27));
        ItemList.managerList[0].setPassword("Varun");


        // Credentials for Manager#2 - Test all the manager setters  
        ItemList.managerList[1] = new Manager();
        ItemList.managerList[1].setName("Di Wang");
        ItemList.managerList[1].setUserName(new UserNameValidation("di_wang"));
        ItemList.managerList[1].setAddress("University Park, 16802");
        ItemList.managerList[1].setDOB(new Date(1990, 5, 6));

        // Credentials for Manager#3 - Test all the manager setters
        ItemList.managerList[2] = new Manager();
        ItemList.managerList[2].setName("Alikhan Amandyk");
        ItemList.managerList[2].setUserName(new UserNameValidation("2"));
        ItemList.managerList[2].setAddress("Vairo Blvd");
        ItemList.managerList[2].setDOB(new Date(1992, 6, 8));
        ItemList.managerList[2].setPassword("");


        ItemList.clientList[0] = new Client();
        ItemList.clientList[0].setName("Varun Patel");
        ItemList.clientList[0].setPassword("1");
        ItemList.clientList[0].setUserName(new UserNameValidation("1"));
        ItemList.clientList[0].setAddress("446 State College 16803");
        ItemList.clientList[0].setDOB(new Date(1990, 4, 27));
        ItemList.clientList[0].setPassword("");

        // Credentials for Client#1 - test all the client setters
        ItemList.clientList[1] = new Client();
        ItemList.clientList[1].setName("Daniel Giannone");
        ItemList.clientList[1].setUserName(new UserNameValidation("big_deezy"));
        ItemList.clientList[1].setAddress("East View Terrace, 16802");
        ItemList.clientList[1].setDOB(new Date(1993, 5, 2));

        // Credentials for Client#2 - test all the client setters
        ItemList.clientList[2] = new Client();
        ItemList.clientList[2].setName("Stephan Carraway");
        ItemList.clientList[2].setUserName(new UserNameValidation("tank_bull"));
        ItemList.clientList[2].setAddress("West Commons, 16802");
        ItemList.clientList[2].setDOB(new Date(1992, 4, 1));

        ItemList.clientSize = 3;
        // Test the toString method for AccountType, Manager, and Class
        for (int i = 0; i < ItemList.clientSize; i++) {
            System.out.println(ItemList.clientList[i].toString());
        }


        // Creating "Pride" and entering credentials. 
        // Store it in the first position of Array musicList
        ItemList.musicList[0] = new Music();
        ItemList.musicList[0].setTitle("Pride");
        ItemList.musicList[0].setArtist("Tiesto ft. U2");
        ItemList.musicList[0].setFilename("preview1.wav");
        ItemList.musicList[0].setPrice(1.99);

        // Print out credentials at musicList[0]
        System.out.println("ProductID for Song- (" + ItemList.musicList[0].getTitle()
                + "  by " + ItemList.musicList[0].getArtist() + ") : "
                + ItemList.musicList[0].getProductID());

        // Create a new test Client- Test the default Constructor and Setters
        Client testClient = new Client();
        testClient.setName("Erich Stoekl");
        testClient.setUserName(new UserNameValidation("i_love_programming"));
        testClient.setAddress("IST 220, State College 16802");
        testClient.setDOB(new Date(1990, 04, 25));
        // deposit funds into the account of Erich
        testClient.depositFunds(25.30);


        // Add items to the shopping cart of test Client
        testClient.getShoppingCart().addItemToCart(ItemList.musicList[0].getProductID());
        // Print you the shopping cart [should have one item]
        System.out.println(testClient.getShoppingCart().viewAllItemsInCart());

        System.out.println();
        System.out.println();

        // Add another item to the shopping cart of test Client
        testClient.getShoppingCart().addItemToCart(ItemList.musicList[0].getProductID());
        // Print out the shopping cart- should have two items. One item, with quantity of 2
        System.out.println(testClient.getShoppingCart().viewAllItemsInCart());

        // Play the preview of the song. The preview is available if not bought
        /**
         * ********* Un-Comment this selection to listen to the
         * preview**************** ********* Un-Comment this selection to listen
         * to the preview**************** ********* Un-Comment this selection to
         * listen to the preview****************
         * ItemList.musicList[0].preview(); try { Thread.sleep(SECOND * TIMER);
         * } catch (InterruptedException ex) {
         * Thread.currentThread().interrupt(); }
         * ItemList.musicList[0].stopPreview();
         */
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
        ItemList.musicList[1] = new Music();
        ItemList.musicList[1].setTitle("Never Say Never");
        ItemList.musicList[1].setArtist("Arminn van Buuren feat. Jacqueline Govaert");
        ItemList.musicList[1].setPrice(0.99);

        System.out.println();

        // Print out credentials at musicList[1]
        System.out.println("ProductID for Song- (" + ItemList.musicList[1].getTitle()
                + "  by " + ItemList.musicList[1].getArtist() + ") : "
                + ItemList.musicList[1].getProductID());

        // Creating "Angel Monster" and entering credentials. 
        // Store it in the third position of Array musicList
        ItemList.musicList[2] = new Music();
        ItemList.musicList[2].setTitle("Angel Monster");
        ItemList.musicList[2].setArtist("Buckethead");
        ItemList.musicList[2].setPrice(1.29);

        System.out.println();
        System.out.println();
        // Print out credentials at musicList[2]
        System.out.println("ProductID for Song- (" + ItemList.musicList[2].getTitle()
                + "  by " + ItemList.musicList[2].getArtist() + ") : "
                + ItemList.musicList[2].getProductID());

        // Add items to the shopping cart of test Client
        testClient.getShoppingCart().addItemToCart(ItemList.musicList[1].getProductID());
        testClient.getShoppingCart().addItemToCart(ItemList.musicList[1].getProductID());
        testClient.getShoppingCart().addItemToCart(ItemList.musicList[2].getProductID());
        // Print the shopping cart [should have one item]
        System.out.println(testClient.getShoppingCart().viewAllItemsInCart());

        // Creating "Soul Surfer" and entering credentials. 
        // Store it in the first position of Array DVDList        
        ItemList.DVDList[0] = new DVD();
        ItemList.DVDList[0].setTitle("Soul Surfer");
        ItemList.DVDList[0].setDirector("Sean McNamara");
        ItemList.DVDList[0].setPrice(4.29);

        System.out.println();
        System.out.println();
        // Print out credentials at DVDList[0]
        System.out.println("ProductID for Movie- (" + ItemList.DVDList[0].getTitle()
                + "  by " + ItemList.DVDList[0].getDirector() + ") : "
                + ItemList.DVDList[0].getProductID());

        // Add items to the shopping cart of test Client
        testClient.getShoppingCart().addItemToCart(ItemList.DVDList[0].getProductID());
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
        ItemList.bookList[0] = new Book();
        ItemList.bookList[0].setTitle("Lord of the Rings");
        ItemList.bookList[0].setAuthor("J. R. R. Tolkien");
        ItemList.bookList[0].setPrice(14.29);

        // Add items to the shopping cart of test Client - Adding a Book
        testClient.getShoppingCart().addItemToCart(ItemList.bookList[0].getProductID());

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
        for (int i = 0; i < ItemList.musicList.length; i++) {
            if (ItemList.musicList[i] == null) {
                break;
            } else {
                System.out.println(ItemList.musicList[i].getTitle());
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();

        testManager.AddContent("Music", "Aruzhan");
        for (int i = 0; i < ItemList.musicList.length; i++) {
            if (ItemList.musicList[i] == null) {
                break;
            } else {
                System.out.println(ItemList.musicList[i].getTitle());
            }
        }

        testManager.retrieveCustomerInformation("ThisIsATest");

        StartPanel.main(args);
    }
}
