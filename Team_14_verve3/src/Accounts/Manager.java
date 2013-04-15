package team_14_verve3;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 *
 */

/*
 * This abstract class contains various methods for managing the Manager user
 * This class extends the abstract AccountType class
 * 
 * @author Alikhan Amandyk
 * @author Varun Patel
 * @author Di Wang
 * @version 1.0 02/15/2013
 */
public class Manager extends AccountType {

    public static final int MAX_SIZE = 50;
    private Music music = new Music();
    private DVD dvd = new DVD();
    private Book book = new Book();
    private Client client = new Client();
    private String[] testString = new String[MAX_SIZE];

    // default Constructor
    public Manager() {
        super();
    }

    public void AddContent(String itemKind, String titleOfItem) {
        boolean isValid = isItemKindValid(itemKind);
        if (isValid == true) {
            itemKind = itemKind.toLowerCase();
            if (itemKind.equals("music")) {
                for (int i = 0; i < ItemList.musicList.length; i++) {
                    if (ItemList.musicList[i] == null) {
                        ItemList.musicList[i] = music;
                        ItemList.musicList[i].setTitle(titleOfItem);
                        break;
                    }
                }
            } else if (itemKind.equals("book")) {
                for (int i = 0; i < ItemList.DVDList.length; i++) {
                    if (ItemList.DVDList[i] == null) {
                        ItemList.DVDList[i] = dvd;
                        ItemList.DVDList[i].setTitle(titleOfItem);
                        break;
                    }
                }
            } else {
                for (int i = 0; i < ItemList.bookList.length; i++) {
                    if (ItemList.bookList[i] == null) {
                        ItemList.bookList[i] = book;
                        ItemList.bookList[i].setTitle(titleOfItem);
                        break;
                    }
                }
            }
        } else {
            System.out.print("Invalid Type of Item entered, Please Check Item Type ");
        }
    }

    private boolean isItemKindValid(String item) {
        String[] itemKind = {"Music", "music", "MUSIC", "DVD",
            "dvd", "Dvd", "Book", "book", "BOOK"};
        for (int i = 0; i < itemKind.length; i++) {
            if (itemKind[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public void retrieveCustomerInformation(String userNameSearch) {
        String testString;
        for (int i = 0; i < ItemList.clientList.length; i++) {
            if (ItemList.clientList[i] == null) {
                System.out.print("No such Client User Name Exists");
                break;
            } else {
                testString = ItemList.clientList[i].getUserName();
                if (testString.equals(userNameSearch)) {
                    System.out.println("Username " + userNameSearch + " is found:");
                    System.out.println(ItemList.clientList[i].toString());
                }
            }
        }
    }

    // will be implemented in the GUI phase
    @Override
    public void panel() {
        // Manager has own panel
    }
}
