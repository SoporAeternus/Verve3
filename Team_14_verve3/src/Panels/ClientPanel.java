package Panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import team_14_verve3.*;

public class ClientPanel extends JApplet implements ActionListener{

    public static JFrame application;
    public static String[] args;
    private JLabel welcomeLabel;
    
    private JPanel output = new JPanel(new BorderLayout());
            
    private JButton home = new JButton("Home");
    private JButton cart = new JButton("My Cart");
    private JButton search = new JButton("Search");
    private JButton mgmt = new JButton("My Account");
    private JButton logout = new JButton("Logout");

    private JPanel homePanel = new JPanel(new BorderLayout());
    private JPanel cartPanel = new JPanel();
    private JPanel searchPanel = new JPanel();
    private JPanel mgmtPanel = new JPanel();
    
    // buttons for homePanel
    private JButton musicButton = new JButton("Music");
    private JButton dvdButton = new JButton("DVD");
    private JButton bookButton = new JButton("Book");
    private DefaultTableModel model = new DefaultTableModel(1,5);
    private JTable items = new JTable(model);
            
    
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    

    public ClientPanel() {
        welcomeLabel = new JLabel("Welcome "
                + ItemList.clientList[ItemList.chosenClientIndex].getName() + "!");
        
        
        layout = new GridBagLayout();
        setLayout(layout);
        constraints = new GridBagConstraints();
        constraints.fill  = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        
        // this is buttons array, used only for testing laying out
        
        JButton[] panel = new JButton[100];
       
        for (int i = 0; i < 100; i++)
        {
            panel[i] = new JButton("button" + i);
            
        }
        
        // empty panels to create nice layout
        JPanel[] panels = new JPanel[100];
        for (int i = 0; i < 100; i++)
        {
            panels[i] = new JPanel();
            //panels[i].setBorder(BorderFactory.createLineBorder(Color.black));
        }
        
        panels[4].setAlignmentY(100);
        panels[4].add(welcomeLabel);
        
        
        // first line with label
        for (int i = 0; i < 8; i++)
        {
            constraints.gridx = i;
            constraints.gridy = 0;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            layout.setConstraints(panels[i], constraints);
            add(panels[i]);
        
        }
        
        
        // second line
        for (int i = 0; i < 8; i++)
        {
            constraints.gridx = i;
            constraints.gridy = 1;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            layout.setConstraints(panels[8+i], constraints);
            add(panels[8+i]);
        
        }
        
        output.setBorder(BorderFactory.createLineBorder(Color.black));
        
        // pink panel
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 8;
        constraints.gridheight = 23;
        layout.setConstraints(output, constraints);
        //layout.setConstraints(searchPanel, constraints);
        //layout.setConstraints(output, constraints);
        //layout.setConstraints(output, constraints);
        add(output);
        
        remove(panels[2]);
        remove(panels[3]);
        remove(panels[4]);  // *need to modify panels4
        remove(panels[5]);
        remove(panels[6]);
        
        
        // the panel with label
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        layout.setConstraints(panels[4], constraints);
        panels[4].setBorder(null);
        add(panels[4]);
        
        constraints.fill = GridBagConstraints.BOTH;
        
        /*
        for (int i = 1; i < 15; i++)
        {
            constraints.gridx = 0;
            constraints.gridy = i;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            layout.setConstraints(panel[10+i], constraints);
            add(panel[10+i]);
        }
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 13;
        layout.setConstraints(panel[10], constraints);
        add(panel[10]);
        */
            
        home.addActionListener(this);
        cart.addActionListener(this);
        search.addActionListener(this);
        mgmt.addActionListener(this);
        logout.addActionListener(this);
        
        constraints.gridx = 10;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        layout.setConstraints(home, constraints);
        add(home);
        
        constraints.gridx = 10;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        layout.setConstraints(cart, constraints);
        add(cart);
        
        constraints.gridx = 10;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        layout.setConstraints(search, constraints);
        add(search);
        
        constraints.gridx = 10;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        layout.setConstraints(mgmt, constraints);
        add(mgmt);
        
        constraints.gridx = 10;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        layout.setConstraints(logout, constraints);
        add(logout);
        
        // east line below five buttons
        for (int i = 0; i < 20; i++)
        {
            constraints.gridx = 10;
            constraints.gridy = 5+i;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            layout.setConstraints(panels[16+i], constraints);
            add(panels[16+i]);
        
        }
        
        
        
        searchPanel.add(new JLabel("Search"));
        cartPanel.add(new JLabel("Shopping Cart"));
        mgmtPanel.add(new JLabel("Management"));
        
        // homePanel defining
        //GridLayout homePanelLayout = new GridLayout(3,1);
        //homePanel.setLayout(homePanelLayout);
        
        /*
        musicButton.addActionListener(this);
        dvdButton.addActionListener(this);
        bookButton.addActionListener(this);
        
        JPanel hp_1 = new JPanel();
        
        hp_1.add(new JLabel("Select what type of item you want to browse:"));
        hp_1.add(musicButton);
        hp_1.add(dvdButton);
        hp_1.add(bookButton);
        
        
        model.setValueAt("PID", 0, 0);
        model.setValueAt("Title", 0, 1);
        model.setValueAt("Author", 0, 2);
        model.setValueAt("Rating", 0, 3);
        model.setValueAt("Price", 0, 4);
        
        homePanel.add(hp_1, BorderLayout.NORTH);
        
        JScrollPane scrollPane = new JScrollPane(items);
        homePanel.add(scrollPane, BorderLayout.CENTER);
        */
        
        
        
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel musicPanel = new JPanel();
        
        model.setValueAt("PID", 0, 0);
        model.setValueAt("Title", 0, 1);
        model.setValueAt("Author", 0, 2);
        model.setValueAt("Rating", 0, 3);
        model.setValueAt("Price", 0, 4);
        JScrollPane scrollPane = new JScrollPane(items);
        musicPanel.add(scrollPane, BorderLayout.CENTER);
        model.setValueAt("Artist", 0, 2);
            while (model.getRowCount() > 1) // clean the table from previous items
            {
                model.removeRow(1);
            }
            
            
            for (int i = 0; ItemList.musicList[i] != null; i++)
            {
                Object[] thisItem = new Object[]
                {ItemList.musicList[i].getProductID(),
                 ItemList.musicList[i].getTitle(),
                 ItemList.musicList[i].getArtist(),
                 ItemList.musicList[i].getPrice(),
                 ItemList.musicList[i].getRating()};
                model.addRow(thisItem);
            }
            
            
        JPanel DVDPanel = new JPanel();
        JPanel bookPanel = new JPanel();
        
        tabbedPane.add("Music", musicPanel);
        tabbedPane.add("DVD", DVDPanel);
        tabbedPane.add("Book", bookPanel);
        
        
        
        homePanel.add(tabbedPane);
        
        output.add(homePanel);
    }

    @Override
    public void init() {
        
    }
    
     @Override 
     public void paint(Graphics g) 
     { 
         super.paint(g); 
     }
    public static void main(String[] args) {
        application = new JFrame();
        ClientPanel clientPanel = new ClientPanel();
        application.setTitle("verve3 Client Panel");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(800, 600);
        application.setResizable(false);
        application.add(clientPanel);
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == home)
        {
            output.removeAll();
            output.add(homePanel);
            output.revalidate();
            output.repaint();
        }
        
        if (e.getSource() == cart)
        {
            output.removeAll();
            output.add(cartPanel);
            output.revalidate();
            output.repaint();
        }
        
        if (e.getSource() == search)
        {
            output.removeAll();
            output.add(searchPanel);
            output.revalidate();
            output.repaint();
        }
        
        if (e.getSource() == mgmt)
        {
            output.removeAll();
            output.add(mgmtPanel);
            output.revalidate();
            output.repaint();
        }
        
        if (e.getSource() == logout)
        {
            application.setVisible(false);
            StartPanel.main(args);
        }
        
        // defining behavior for buttons from homePanel
        if (e.getSource() == musicButton)
        {
            model.setValueAt("Artist", 0, 2);
            while (model.getRowCount() > 1) // clean the table from previous items
            {
                model.removeRow(1);
            }
            
            
            for (int i = 0; ItemList.musicList[i] != null; i++)
            {
                Object[] thisItem = new Object[]
                {ItemList.musicList[i].getProductID(),
                 ItemList.musicList[i].getTitle(),
                 ItemList.musicList[i].getArtist(),
                 ItemList.musicList[i].getPrice(),
                 ItemList.musicList[i].getRating()};
                model.addRow(thisItem);
            }
            
            
        }
        
        if (e.getSource() == dvdButton)
        {
            model.setValueAt("Producer", 0, 2);
            while (model.getRowCount() > 1) // clean the table from previous items
            {
                model.removeRow(1);
            }
            
            
            for (int i = 0; ItemList.DVDList[i] != null; i++)
            {
                Object[] thisItem = new Object[]
                {ItemList.DVDList[i].getProductID(),
                 ItemList.DVDList[i].getTitle(),
                 ItemList.DVDList[i].getProducer(),
                 ItemList.DVDList[i].getPrice(),
                 ItemList.DVDList[i].getRating()};
                model.addRow(thisItem);
            }
        }
        
        if (e.getSource() == bookButton)
        {
            model.setValueAt("Author", 0, 2);
            while (model.getRowCount() > 1) // clean the table from previous items
            {
                model.removeRow(1);
            }
            
            
            for (int i = 0; ItemList.bookList[i] != null; i++)
            {
                Object[] thisItem = new Object[]
                {ItemList.bookList[i].getProductID(),
                 ItemList.bookList[i].getTitle(),
                 ItemList.bookList[i].getAuthor(),
                 ItemList.bookList[i].getRating(),
                 ItemList.bookList[i].getPrice()};
                model.addRow(thisItem);
            }
        }
    }
}
