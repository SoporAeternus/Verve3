package Database;
import Products.Order;
import Accounts.*;
import Products.*;
import java.util.*;
import java.io.*;


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
    public static void preload() throws Exception
    {
    	Scanner in;
    	// load music
    	in = new Scanner(new File("src\\Database\\Music.txt"));
    	while(in.hasNext())
    	{
    		String tmp = in.nextLine();
    		String[] newMusic = tmp.split("/");
    		musicList.add(new Music(newMusic));
    	}

    	// load book
    	in = new Scanner(new File("src\\Database\\Book.txt"));
    	while(in.hasNext())
    	{
    		String tmp = in.nextLine();
    		String[] newBook = tmp.split("/");
    		bookList.add(new Book(newBook));
    	}

    	// load DVD
    	in = new Scanner(new File("src\\Database\\DVD.txt"));
    	while(in.hasNext())
    	{
    		String tmp = in.nextLine();
    		String[] newDVD = tmp.split("/");
    		DVDList.add(new DVD(newDVD));
    	}

    	// load Accounts
    	in = new Scanner(new File("src\\Database\\Accounts.txt"));
    	while(in.hasNext())
    	{
    		String tmp = in.nextLine();
    		String[] newUser = tmp.split("/");
                if(newUser[0].equals("M"))
                {
                    AccountList.add(new Manager(newUser));
                }
                if(newUser[0].equals("C"))
                {
                    AccountList.add(new Client(newUser));
                }
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
    
    public static void update()
    {
        
    }
}
