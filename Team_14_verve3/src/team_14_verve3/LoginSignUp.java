package team_14_verve3;

import java.util.Date;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 *
 */

/*
 * This is a redundant Class for Phase 1. - Once knowledge of GUI and SQL is gained,
 * it will be completed then. 
 * 
 * @author Alikhan Amandyk
 * @author Varun Patel
 * @author Di Wang
 * @version 1.0 02/15/2013
 */
public class LoginSignUp {

    // Will be Implemented from GUI then from In depth with SQL
    public void logIn() {
    }

    // Will be Implemented from GUI then from In depth with SQL
    public void signUp() {
        // SQL must be used
        // it's an example how a new Client account will be created
        Client newClient1 = new Client();         // this is for example
        String newName = "Will be from GUI";
        String newAddress = "Will be from GUI";
        Date newDOB = new Date(1990, 02, 02);
        newClient1.setName(newName);
        newClient1.setAddress(newAddress);
        newClient1.setDOB(newDOB);
    }
}
