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
import java.sql.PreparedStatement;
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
<<<<<<< HEAD
          try
            {
                String currDir = System.getProperty("user.dir");
                String dir = currDir.replace("\\","/");
                dir += "/src/Database/VERVE3";
                System.out.println(dir);
                myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/"+dir,"root","root");
                load("ACCOUNTS");
                load("MUSIC");
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
            String loadQuery;
            Statement stmt;
            ResultSet results;
            loadQuery = "select * from ROOT."+type;
            stmt = myConnection.createStatement();
            results = stmt.executeQuery(loadQuery);
            if(type.equals("MUSIC"))
            {
                 while(results.next())
=======
    	Scanner in;
    	// load music
    	in = new Scanner(new File("src/Database/Music.txt"));
    	while(in.hasNext())
    	{
    		String tmp = in.nextLine();
    		String[] newMusic = tmp.split("/");
    		musicList.add(new Music(newMusic));
    	}

    	// load book
    	in = new Scanner(new File("src/Database/Book.txt"));
    	while(in.hasNext())
    	{
    		String tmp = in.nextLine();
    		String[] newBook = tmp.split("/");
    		bookList.add(new Book(newBook));
    	}

    	// load DVD
    	in = new Scanner(new File("src/Database/DVD.txt"));
    	while(in.hasNext())
    	{
    		String tmp = in.nextLine();
    		String[] newDVD = tmp.split("/");
    		DVDList.add(new DVD(newDVD));
    	}

    	// load Accounts
    	in = new Scanner(new File("src/Database/Accounts.txt"));
    	while(in.hasNext())
    	{
    		String tmp = in.nextLine();
    		String[] newUser = tmp.split("/");
                if(newUser[0].equals("M"))
>>>>>>> Shopping Cart
                {

                    Music m = new Music();
                    m.setPID(results.getString("PID"));
                    m.setTitle(results.getString("TITLE")); 
                    m.setArtist(results.getString("ARTIST"));
                    m.setRating(results.getDouble("RATING"));
                    m.setPrice(results.getDouble("PRICE"));
                    musicList.add(m);
                }
            }
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
            JOptionPane.showMessageDialog(null, "Error occured when trying to load " +type+" database\nPlease check your connection.\n"
                    +ex.getMessage());
        }
    }
    
    public static boolean addMusic(Music newMusic)
    {
        try
        {
            boolean found = false;
            musicList.add(newMusic);
            String addQuery;
            String currDir = System.getProperty("user.dir");
            String dir = currDir.replace("\\","/");
            dir += "/src/Database/VERVE3";
            myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/"+dir,"root","root");
            PreparedStatement statement = myConnection.prepareStatement("INSERT INTO ROOT.MUSIC (PID, TITLE,ARTIST,RATING,PRICE) VALUES (?,?,?,?,?)");
            statement.setString(1, newMusic.getProductID());
            statement.setString(2, newMusic.getTitle());
            statement.setString(3, newMusic.getArtist());
            statement.setDouble(4,newMusic.getRating());
            statement.setDouble(5, newMusic.getPrice());
            statement.execute();
            statement.close();
            myConnection.close();
            return true;
        }
        catch(Exception ex)
        {
             JOptionPane.showMessageDialog(null, "Error occured when trying to add the new item."
                        + "\nError Message: "+ex.getMessage());
             return false;
        }
    }
    
    public static boolean addDVD(DVD newDVD)
    {
        boolean result = true;
        return true;
    }
    public static boolean addBook(Book newBook)
    {
        boolean result = true;
        return true;
    }
}
