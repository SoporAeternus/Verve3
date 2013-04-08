package team_14_verve3;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 *
 */

/*
 * This class contains various methods for managing the Searching of various Items
 * by a user. Redundant for now- will be implemented fully by next phase and 
 * will be fully and efficiently implemented by SQL phase
 * 
 * @author Alikhan Amandyk
 * @author Varun Patel
 * @author Di Wang
 * @version 1.0 02/15/2013
 */
public class Search {

    public static final int NOT_FOUND = -1;   // NOT_FOUND when not found in data searched
    private String userName;                  // used to search user names
    private String artist;                    // used to search name of artist
    private String title;                     // used to search the title of Items
    private String ratings;                   // used to search the top ratings of Items

    // default oonstructor
    public Search() {
        userName = "";
        artist = "";
        title = "";
        ratings = "";
    }

    public boolean searchUsername(String userName) {
        this.userName = userName;
        // it's supposed to access SQL database with the list of all acoounts
        // and look for userName there
        // if found, then the information is displayed in the panel
        // and FCTVAL is true
        // otherwise FCTVAL is false
        return true;
    }

    public void searchArtist() {
        // similar to searchUsername
        // do Something
    }

    public void searchTitle() {
        // returns productID of item with title
        // if not found, returns NOT_FOUND
        // similar to searchUsername
    }

    public void searchTopRatings() {
        // similar to searchUsername
    }
}
