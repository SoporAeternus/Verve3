package team_14_verve3;

import java.util.Arrays;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 *
 */

/*
 * This class contains various methods for managing the Validation of a Client
 * and Manager Username
 * 
 * @author Alikhan Amandyk
 * @author Varun Patel
 * @author Di Wang
 * @version 1.0 02/15/2013
 */
public class UserNameValidation {

    private String userName;                    // user name of user to be checked
    // String of Valid Characters
    private static final String VALID_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890.-'+_";
    public int userNameLength;                  // length of user name
    static final int NOT_FOUND = -1;            // not Found- for efficiency and security- used 
    // to check if valid character was found or not
    static final int UPPER_BOUND = 64;          // max length of username
    static final int LOWER_BOUND = 1;           // min length of username

    // default constructor
    public UserNameValidation() {
        userName = "";
    }

    // Init Constructor
    public UserNameValidation(String userName) {
        this.userName = userName;

    }

    /**
     * Set function acts as Init Constructor to Set user Name
     *
     * @param userName final because of security purposes
     */
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        // POST: returns the userName
        return this.userName;
    }

    /**
     * IsValidFunction Checks the UserName and validates it. Boolean function
     *
     * true if username is Valid false otherwise
     */
    public boolean isValid() {
        // userName is checked for it's length
        // and if it has invalid characters

        String aChar;
        userNameLength = this.userName.length();
        int validCharsLength = VALID_CHARACTERS.length();

        if ((userNameLength < LOWER_BOUND) || (userNameLength > UPPER_BOUND)) {
            return false;
        }

        boolean charFound;
        for (int i = 0; i < userNameLength; i++) {
            charFound = false;
            aChar = "" + userName.charAt(i);
            for (int j = 0; j < validCharsLength; j++) {
                if (aChar.indexOf(VALID_CHARACTERS.charAt(j)) != NOT_FOUND) {
                    charFound = true;
                }
            }
            if (charFound == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * toString Method returns userName
     */
    public String toString() {
        return String.format(userName);
    }
}
