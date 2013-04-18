package Database;
import Products.Order;
import Accounts.*;
import Panels.ClientPanel;
import Panels.ManagerPanel;
import Products.*;
import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import team_14_verve3.UserNameValidation;


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
public class Database{

    public static Vector<Music> musicList = new Vector<Music>();  // Array of Music at verve3
    public static Vector<DVD> DVDList = new Vector<DVD>();        // Array of DVDs at verve3
    public static Vector<Book> bookList = new Vector<Book>();     // Array of Books at verve3
    public static Vector<Account> AccountList = new Vector<Account>();
    public static Vector<Order> Orders = new Vector<Order>();
    private static Connection myConnection;
    public static void preload()
    {
          try
            {
                String currDir = System.getProperty("user.dir");
                String dir = currDir.replace("\\","/");
                dir += "/src/Database/VERVE3";
                System.out.println(dir);
                myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/"+dir,"root","root");
                load("ACCOUNTS");
                myConnection.close();
            }
            catch(Exception exception){
                
                JOptionPane.showMessageDialog(null, "Error occured when trying to connect to database\nPlease check your connection."
                        + "\nError Code: "+exception.getMessage());
            }
    }
    
    public static void load(String type)
    {
        try
        {
            String testQuery;
            Statement stmt;
            ResultSet results;
            testQuery = "select * from ROOT."+type;
            stmt = myConnection.createStatement();
            results = stmt.executeQuery(testQuery);
            if(type.equals("ACCOUNTS"))
            {
                while(results.next())
                {

                    String accountType = results.getString("ACCOUNT_TYPE");
                    if(accountType.equals("M"))
                    {
                        Manager m = new Manager();
                        m.setAccountType(accountType);
                        m.setUserName(results.getString("USERNAME")); 
                        m.setPassword(results.getString("PASSWORD"));
                        m.setName(results.getString("NAME"));
                        m.setAddress(results.getString("NAME"));
                        int Y = results.getDate("DOB").getYear();
                        int M = results.getDate("DOB").getMonth();
                        int D = results.getDate("DOB").getDay();
                        m.setDOB(new Date(Y,M,D));
                        AccountList.add(m);
                    }
                    if(accountType.equals("C"))
                    {
                        Client c = new Client();
                        c.setAccountType(accountType);
                        c.setUserName(results.getString("USERNAME")); 
                        c.setPassword(results.getString("PASSWORD"));
                        c.setName(results.getString("NAME"));
                        c.setAddress(results.getString("NAME"));
                        int Y = results.getDate("DOB").getYear();
                        int M = results.getDate("DOB").getMonth();
                        int D = results.getDate("DOB").getDay();
                        c.setDOB(new Date(Y,M,D));
                        c.setBalance(results.getDouble("BALANCE"));
                        AccountList.add(c);
                    }
                }
            }
            results.close();
            stmt.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error occured when trying to load" +type+" database\nPlease check your connection.");
        }
    }
    
    public static boolean addMusic()
    {
        boolean result = true;
        return result;
    }
    public static boolean addDVD()
    {
        boolean result = true;
        return result;
    }
    public static boolean addBook()
    {
        boolean result = true;
        return result;
    }
}
