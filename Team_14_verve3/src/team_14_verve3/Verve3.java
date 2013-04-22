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
public class Verve3{

    public static final int MAX_SIZE = 20; // used for AccountType Vector size
    public static final int SECOND = 1000;
    public static final int TIMER = 10; // 10 second preview

    public static void main(String[] args) throws Exception{
        Database.preload();
        StartPanel.main(args);
    }
}
