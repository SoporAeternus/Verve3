package Accounts;

import Database.*;
import Products.*;
import team_14_verve3.UserNameValidation;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 *
 */

/*
 * This abstract class contains various methods for managing the Manager user
 * This class extends the abstract Account class
 * 
 * @author Alikhan Amandyk
 * @author Varun Patel
 * @author Di Wang
 * @version 1.0 02/15/2013
 */
public class Manager extends Account {

    //public static final int MAX_SIZE = 50;
    //private Music music = new Music();
    //private DVD dvd = new DVD();
   // private Book book = new Book();
    //private Client client = new Client();
   // private String[] testString = new String[MAX_SIZE];

    // default Constructor
    public Manager()
    {
        super();
    }
   
/*
    public void AddContent(String itemKind, String titleOfItem) {
        boolean isValid = isItemKindValid(itemKind);
        if (isValid == true) {
            itemKind = itemKind.toLowerCase();
            if (itemKind.equals("music")) {
                for (int i = 0; i < Database.musicList.length; i++) {
                    if (Database.musicList[i] == null) {
                        Database.musicList[i] = music;
                        Database.musicList[i].setTitle(titleOfItem);
                        break;
                    }
                }
            } else if (itemKind.equals("book")) {
                for (int i = 0; i < Database.DVDList.length; i++) {
                    if (Database.DVDList[i] == null) {
                        Database.DVDList[i] = dvd;
                        Database.DVDList[i].setTitle(titleOfItem);
                        break;
                    }
                }
            } else {
                for (int i = 0; i < Database.bookList.length; i++) {
                    if (Database.bookList[i] == null) {
                        Database.bookList[i] = book;
                        Database.bookList[i].setTitle(titleOfItem);
                        break;
                    }
                }
            }
        } else {
            System.out.print("Invalid Type of Item entered, Please Check Item Type ");
        }
    }*/

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
}
